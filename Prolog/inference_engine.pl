% Version prepared to deal with rules that contain negation (not)
% Metaknowledge
% how? and whynot? explanations supported
% Use knowledge base "vehicles2.txt"

:-op(220,xfx,then).
:-op(35,xfy,if).
:-op(240,fx,rule).
:-op(500,fy,not).
:-op(700,xfy,or).
:-op(600,xfy,and).

:-dynamic justify/3,fact_triggers_rules/2.

cleanup_db :-
      retractall(fact(_,_)).

load_kb:-
	write('File name for knowledge base (end with dot) -> '),
	read(NBC),
	consult(NBC).

start_engine:-
	calculate_last_fact,
	calculate_last_rule,
	generate_metaknowledge([aocs_thermal(_,_), aocs_thermalFailure(_, _), aocs(_, _),
		aocs_tension(_, _), aocs_tensionFailure(_, _), aocs_current(_, _), aocs_currentFailure(_, _),
		aocs_switch(_, _), aocs_switchFailure(_, _), aocs_gyroscope(_, _), aocs_attitudeFailure(_, _), 
		aocs_gps(_, _), aocs_gpsFailure(_, _), aocs_star_tracker(_, _), power_current_output(_, _), 
		power_currentOutputFailure(_, _), power_battery_status(_, _), power_batteryFailure(_, _), 
		power_batteryWarning(_, _), power_current_input(_, _), power_currentInputFailure(_, _), 
		obc_battery_status(_, _), aocs_navigationFailure(_,_), aocs_reaction_wheel(_,_), aocs_thruster(_,_),
		power_thermal(_,_), power_thermalFailure(_,_), power_tension(_,_), power_tensionFailure(_,_),
		power_current(_,_), power_currentFailure(_,_), power_switch(_,_), power_switchFailure(_,_),
		power_switchFailure(_,_), power_switchFailure(_,_), power_switchFailure(_,_),
		payload_thermal(_,_), payload_thermalFailure(_,_), payload_tension(_,_), payload_tensionFailure(_,_),
		payload_current(_,_), payload_currentFailure(_,_), payload_switch(_,_), payload_switchFailure(_,_),
		payload_switchFailure(_,_), payload_switchFailure(_,_), payload_switchFailure(_,_),
		communication_thermal(_,_), communication_thermalFailure(_,_), communication_tension(_,_), communication_tensionFailure(_,_),
		communication_current(_,_), communication_currentFailure(_,_), communication_switch(_,_), communication_switchFailure(_,_),
		communication_groundConnectionFailure(_,_),
		obc_thermal(_,_), obc_thermalFailure(_,_), obc_tension(_,_), obc_tensionFailure(_,_),
		obc_current(_,_), obc_currentFailure(_,_), obc_switch(_,_), obc_switchFailure(_,_), obc_ground_connection(_,_), 
		payload(_,_), communication(_,_), power(_,_), obc(_,_)
	]),
	fact(N,Fact),
	fact_triggers_rules1(Fact, LRules),
	trigger_rules(N, Fact, LRules),
	last_fact(N).

fact_triggers_rules1(Fact, LRules):-
	fact_triggers_rules(Fact, LRules),
	!.
fact_triggers_rules1(_, []).
% Case where there are no rules associated with the fact being considered.

trigger_rules(N, Fact, [ID|LRules]):-
	% get the rule from our knowledge database
	rule ID if LHS then RHS,
	fact_is_in_condition(Fact,LHS),
	% verify_conditions will check for all the facts that are true for LHS.
	verify_conditions(LHS, LFacts),
	% we will then check if the fact being considered is in that list 
	member(N,LFacts),
	% for explanation module purposes, the whole list of facts is then written to a justify/3 fact
	conclude(RHS,ID,LFacts),
	!,
	trigger_rules(N, Fact, LRules).

trigger_rules(N, Fact, [_|LRules]):-
	trigger_rules(N, Fact, LRules).

trigger_rules(_, _, []).


fact_is_in_condition(F,[F  and _]).
fact_is_in_condition(F,[evaluate(F1) and _]):- F=..[H,H1|_],F1=..[H,H1|_].
fact_is_in_condition(F,[evaluate_fact_values(F1,_,_) and _]):- F=..[H,H1|_],F1=..[H,H1|_].
fact_is_in_condition(F,[evaluate_fact_values(_,_,F1) and _]):- F=..[H,H1|_],F1=..[H,H1|_].
fact_is_in_condition(F,[_ and Fs]):- fact_is_in_condition(F,[Fs]).

fact_is_in_condition(F,[F  or _]).
fact_is_in_condition(F,[evaluate(F1) or _]):- F=..[H,H1|_], F1=..[H,H1|_], !.
fact_is_in_condition(F,[evaluate_fact_values(F1,_,_) or _]):- F=..[H,H1|_], F1=..[H,H1|_], !.
fact_is_in_condition(F,[evaluate_fact_values(_,_,F1) or _]):- F=..[H,H1|_], F1=..[H,H1|_], !.
fact_is_in_condition(F,[_ or Fs]):- fact_is_in_condition(F,[Fs]).

fact_is_in_condition(F,[F]):-!.

fact_is_in_condition(F,[evaluate(F1)]):-F=..[H,H1|_],F1=..[H,H1|_].
fact_is_in_condition(F,[evaluate_fact_values(F1,_,_)]):-F=..[H,H1|_],F1=..[H,H1|_].
fact_is_in_condition(F,[evaluate_fact_values(_,_,F1)]):-F=..[H,H1|_],F1=..[H,H1|_].

% and - part1
verify_conditions([not evaluate(X) and Y],[not X|LF]):- !,
	\+ evaluate(_,X),
	verify_conditions([Y],LF).
verify_conditions([evaluate(X) and Y],[N|LF]):- !,
	evaluate(N,X),
	verify_conditions([Y],LF).

% Added custom method that validates values from two facts
verify_conditions([evaluate_fact_values(F1,Op,F2) and Y],LAux):- !,
	evaluate_fact_values(F1,Op,F2, N),
	append(N,LF, LAux),
	verify_conditions([Y],LF).

% or - part1
verify_conditions([not evaluate(X) or Y],[not X|LF]):-
	\+ evaluate(_,X);
	verify_conditions([Y],[not X|LF]).
verify_conditions([evaluate(X) or Y],[N|LF]):-
	evaluate(N,X);
	verify_conditions([Y],[N|LF]).

verify_conditions([not evaluate(X)],[not X]):- !, \+ evaluate(_,X).
verify_conditions([evaluate(X)],[N]):- !, evaluate(N,X).

% Added custom method that validates values from two facts
verify_conditions([evaluate_fact_values(F1,Op,F2) or Y],LF):-
	evaluate_fact_values(F1,Op,F2, N),
	append(N,LF, LF);
	verify_conditions([Y],LF).

verify_conditions([evaluate_fact_values(F1,Op,F2)],N):- !, evaluate_fact_values(F1,Op,F2,N).

% and - part2
verify_conditions([not X and Y],[not X|LF]):- !,
	\+ fact(_,X),
	verify_conditions([Y],LF).
verify_conditions([X and Y],[N|LF]):- !,
	fact(N,X),
	verify_conditions([Y],LF).

% or -part2
verify_conditions([not X or Y],[not X|LF]):-
	\+ fact(_,X);
	verify_conditions([Y],[not X|LF]).
verify_conditions([X or Y],[N|LF]):-
	fact(N,X);
	verify_conditions([Y],[N|LF]).

verify_conditions([not X],[not X]):- !, \+ fact(_,X).
verify_conditions([X],[N]):- fact(N,X).



conclude([create_fact(F)|Y],ID,LFacts):-
	!,
	create_fact(F,ID,LFacts),
	test_new_fact(F),
	conclude(Y,ID,LFacts).

conclude([],_,_):-!.


test_new_fact(Fact):- 
	% get N (ID of the Fact) using the fact received as parameter
	fact(N, Fact),
	fact_triggers_rules1(Fact, LRules),
	trigger_rules(N, Fact, LRules).

create_fact(F,_,_):-
	fact(_,F),!.

create_fact(F,ID,LFacts):-
	retract(last_fact(N1)),
	N is N1+1,
	asserta(last_fact(N)),
	assertz(justify(N,ID,LFacts)),
	assertz(fact(N,F)),
	write('Fact no.'),write(N),write(' was concluded'),write(' -> '),write(F),get0(_),!.



evaluate(N,P):-	P=..[Functor,Entity,Operand,Value],
	P1=..[Functor,Entity,Value1],
	fact(N,P1),
	compare2(Value1,Operand,Value).


evaluate_fact_values(F1,Operand,F2, [N1,N2]):-
	F1=..[_,_,Value],
	fact(N1,F1),
	F2=..[_,_,Value2],
	fact(N2,F2),
	compare2(Value,Operand,Value2),!.

compare2(V1,==,V):- V1==V.
compare2(V1,\==,V):- V1\==V.
compare2(V1,>,V):-V1>V.
compare2(V1,<,V):-V1<V.
compare2(V1,>=,V):-V1>=V.
compare2(V1,=<,V):-V1=<V.


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Display knowledge base

show_facts:-
	findall(N, fact(N, _), LFacts),
	write_facts(LFacts).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Generate "How" explanations

how(N):-last_fact(Last),Last<N,!,
	write('That fact does not exist.'),nl,nl.
how(N):-justify(N,ID,LFacts),!,
	fact(N,F),
	write('Fact no.'),write(N),write(' \"'),writeq(F),write('\"'), 
	write(' can be concluded from rule '),write(ID),
	write(' after verifying that: '),nl,tab(8),
	write_facts(LFacts), nl,
	explain(LFacts).
how(N):-fact(N,F),
	write('Fact no.'),write(N),write(' \"'),writeq(F),write('\"'),
	write(' was initially known.'),nl.


write_facts([I|R]):-fact(I,F), !,
	write('Fact no. '),write(I),write(' -> '),write(F),write(' is true.'),nl,
	write_facts(R).
write_facts([I|R]):-
	write('Condition '),write(I),write(' is true.'),nl,
	write_facts(R).
write_facts([]).

explain([I|R]):- \+ integer(I),!,explain(R).
explain([I|R]):-how(I),
	explain(R).
explain([]):-nl.




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Generate "Why not" explanations
% e.g.
% ?- whynot(class(my_vehicle,light)).

whynot(Fact):-
	whynot(Fact,1).

whynot(Fact,_):-
	fact(_, Fact),
	!,
	write('Fact '),write(Fact),write(' is not false!'),nl.
whynot(Fact,Level):-
	find_rules_whynot(Fact,LLPF),
	whynot1(LLPF,Level).
whynot(not Fact,Level):-
	format(Level),write('Because:'),write(' Fact '),write(Fact),
	write(' is true.'),nl.
whynot(Fact,Level):-
	format(Level),write('Because:'),write(' Fact '),write(Fact),
	write(' is not defined in the knowledge base.'),nl.

%  Explanations given by whynot/1 should consider all the rules that could a conclusion related to the fact it receives as an argument

find_rules_whynot(Fact,LLPF):-
	findall((ID,LPF),
	(
		rule ID if LHS then RHS,
		member(create_fact(Fact),RHS),
		find_fake_premisses(LHS,LPF),
		LPF \== []
	),
	LLPF).

whynot1([],_).
whynot1([(ID,LPF)|LLPF],Level):-
	format(Level),write('Because of rule '),write(ID),write(':'),nl,
	Level1 is Level+1,
	explain_why_not(LPF,Level1),
	whynot1(LLPF,Level).

find_fake_premisses([not X and Y], LPF):-
	verify_conditions([not X], _),
	!,
	find_fake_premisses([Y], LPF).
find_fake_premisses([X and Y], LPF):-
	verify_conditions([X], _),
	!,
	find_fake_premisses([Y], LPF).
find_fake_premisses([not X], []):-
	verify_conditions([not X], _),
	!.
find_fake_premisses([X], []):-
	verify_conditions([X], _),
	!.
find_fake_premisses([not X and Y], [not X|LPF]):-
	!,
	find_fake_premisses([Y], LPF).
find_fake_premisses([X and Y], [X|LPF]):-
	!,
	find_fake_premisses([Y], LPF).
find_fake_premisses([not X], [not X]):-!.
find_fake_premisses([X], [X]).
find_fake_premisses([]).

explain_why_not([],_).
explain_why_not([not evaluate(X)|LPF],Level):-
	!,
	format(Level),write('The condition not '),write(X),write(' is false.'),nl,
	explain_why_not(LPF,Level).
explain_why_not([evaluate(X)|LPF],Level):-
	!,
	format(Level),write('The condition '),write(X),write(' is false.'),nl,
	explain_why_not(LPF,Level).
explain_why_not([P|LPF],Level):-
	format(Level),write('The premisse '),write(P),write(' is false.'),nl,
	Level1 is Level+1,
	whynot(P,Level1),
	explain_why_not(LPF,Level).

format(Level):-
	Esp is (Level-1)*5, tab(Esp).



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Metaknowledge

calculate_last_fact:-
	findall(ID, ( fact(ID, _) ) , LID),
	retractall(last_fact(_)),
	last(Last, LID),
	assertz(last_fact(Last)).

calculate_last_rule:-
	findall(ID, ( rule ID if _ then _ ) , LID),
	retractall(last_rule(_)),
	last(Last, LID),
	assertz(last_rule(Last)).

last(X,[X]):-!.
last(X,[_|Z]) :- last(X,Z).

generate_metaknowledge([]).

generate_metaknowledge([F|LF]):-generate_metaknowledge1(F),
	generate_metaknowledge(LF).

generate_metaknowledge1(F):-
	findall(ID,(rule ID if LHS then _ , fact_is_in_condition(F,LHS)),LID2), sort(LID2, LID), 
	((LID==[ ],!) ; assertz(fact_triggers_rules(F,LID))).
