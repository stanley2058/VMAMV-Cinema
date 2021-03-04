#!/bin/bash

mvn clean package -Dmaven.test.failure.ignore=true -fail-never

cp target/vmamv-eureka-client-0.0.1-SNAPSHOT.jar.original vmamv-eureka-client-0.0.1-SNAPSHOT.jar
mvn install:install-file \
    -Dfile=vmamv-eureka-client-0.0.1-SNAPSHOT.jar \
    -DgroupId=com.soselab \
    -DartifactId=vmamv-eureka-client \
    -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar
