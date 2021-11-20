FROM jboss/wildfly:14.0.0.Final

LABEL maintainer="autonomosdrifting.meia@isep.ipp.pt"

ENV KIESERVER_VERSION 7.15.0.Final
ENV DEPLOYMENTS /opt/jboss/wildfly/standalone/deployments
ENV BIN /opt/jboss/wildfly/bin

RUN cd $HOME \
&& curl -O https://download.jboss.org/drools/release/$KIESERVER_VERSION/kie-server-distribution-$KIESERVER_VERSION.zip \
&& unzip kie-server-distribution-$KIESERVER_VERSION.zip \
&& mv $HOME/kie-server-$KIESERVER_VERSION-ee7.war $DEPLOYMENTS \
&& rm kie-server-distribution-$KIESERVER_VERSION.zip \
&& rm *.war \
&& rm *.jar

# Install Kie Workbench
RUN cd $HOME \
&& curl -O https://download.jboss.org/drools/release/$KIESERVER_VERSION/business-central-$KIESERVER_VERSION-wildfly14.war \
&& mv $HOME/business-central-$KIESERVER_VERSION-wildfly14.war $DEPLOYMENTS

# Create users in Wildfly
RUN $BIN/add-user.sh admin admin01!
RUN $BIN/add-user.sh -a -u kieserver -p kieserver1! -ro admin,kie-server,rest-all
RUN $BIN/add-user.sh -a -u droolswb -p droolswb1! -ro admin,kie-server,rest-all

# Avoid out of memory exception
RUN sed -i 's/-Xmx512m/-Xmx2G/' $BIN/standalone.conf \
    && sed -i 's/-XX:MaxMetaspaceSize=256m/-XX:MaxMetaspaceSize=2G/' $BIN/standalone.conf

# Install SAT Container
RUN mkdir -p /opt/jboss/.m2/repository/org/engcia/MEIA2021-TEAM6/1.0-SNAPSHOT
RUN mkdir -p /opt/jboss/repositories/kie/global/org/engcia/MEIA2021-TEAM6/1.0-SNAPSHOT
COPY pom.xml /opt/jboss/.m2/repository/org/engcia/MEIA2021-TEAM6/1.0-SNAPSHOT/MEIA2021-TEAM6-1.0-SNAPSHOT.xml
COPY pom.xml /opt/jboss/repositories/kie/global/org/engcia/MEIA2021-TEAM6/1.0-SNAPSHOT/MEIA2021-TEAM6-1.0-SNAPSHOT.xml
COPY build/MEIA2021-TEAM6-1.0-SNAPSHOT.jar /opt/jboss/.m2/repository/org/engcia/MEIA2021-TEAM6/1.0-SNAPSHOT/
COPY build/MEIA2021-TEAM6-1.0-SNAPSHOT.jar /opt/jboss/repositories/kie/global/org/engcia/MEIA2021-TEAM6/1.0-SNAPSHOT/


# Install Frontend

EXPOSE 8080 9990

CMD $BIN/standalone.sh -b=0.0.0.0 -bmanagement=0.0.0.0 -c=standalone-full.xml -Dorg.kie.server.id=kie-server \
-Dorg.kie.server.location=http://localhost:8080/kie-server-$KIESERVER_VERSION-ee7/services/rest/server \
-Dorg.kie.server.user=kieserver -Dorg.kie.server.pwd=kieserver1! -Dorg.kie.server.controller.user=kieserver \
-Dorg.kie.server.controller.pwd=kieserver1! \
-Dorg.kie.server.controller=http://localhost:8080/business-central-$KIESERVER_VERSION-wildfly14/rest/controller