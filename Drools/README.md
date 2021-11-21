# HOW TO RUN THIS APP

## Building the Docker Image

    make buildx

## Push the Image to the Registry

    make push

## Running

    make run

## Access Wildfly management web interface:

    http://localhost:8080
    User: admin
    Password: admin01!

## Access Kiesever (return Kieserver status):

    http://localhost:8080/kie-server-7.15.0.Final-ee7/services/rest/server
    User: kieserver
    Password: kieserver1!

## Access Kiesever (return Kieserver containers):

    http://localhost:8080/kie-server-7.15.0.Final-ee7/services/rest/server/containers

## Access Workbench:

    http://localhost:8080/business-central-7.15.0.Final-wildfly14/
    User: kieserver
    Password: kieserver1!

## Access Haemorrhage web client:

    http://127.0.0.1:8080/HaemorrhageWebClient/diagnosis.html