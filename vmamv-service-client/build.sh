#!/bin/bash

mvn clean package -Dmaven.test.failure.ignore=true -fail-never

cp target/vmamv-service-client-0.0.1-SNAPSHOT.jar.original vmamv-service-client-0.0.1-SNAPSHOT.jar
mvn install:install-file \
    -Dfile=vmamv-service-client-0.0.1-SNAPSHOT.jar \
    -DgroupId=com.soselab \
    -DartifactId=vmamv-service-client \
    -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar
