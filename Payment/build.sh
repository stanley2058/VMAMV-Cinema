#!/bin/bash

mvn clean test package -Dmaven.test.failure.ignore=true
mvn install -Dmaven.test.skip=true

cp ./target/payment-0.0.1-SNAPSHOT.jar .
docker stop Payment || true
docker rm Payment || true
docker build -t payment:latest .
