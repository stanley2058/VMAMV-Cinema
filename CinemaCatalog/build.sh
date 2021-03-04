#!/bin/bash

mvn clean test -Dmaven.test.failure.ignore=true
mvn install -Dmaven.test.skip=true

cp ./target/cinemacatalog-0.0.1-SNAPSHOT.jar .
docker stop CinemaCatalog || true
docker rm CinemaCatalog || true
docker build -t cinemacatalog:latest .
