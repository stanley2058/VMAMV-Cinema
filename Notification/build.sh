#!/bin/bash

mvn clean test package -Dmaven.test.failure.ignore=true
mvn install -Dmaven.test.skip=true

cp ./target/notification-0.0.1-SNAPSHOT.jar .
docker stop Notification || true
docker rm Notification || true
docker build -t notification:latest .
