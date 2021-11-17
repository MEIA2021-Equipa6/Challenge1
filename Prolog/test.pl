:-dynamic pessoa/1.

pessoa(luis).
pessoa(joana).

animal(cao).
animal(gato).

test:-pessoa(X), animal(Y), print(X), nl, print(Y), nl, !, assertz(pessoa(pedro)), fail.
