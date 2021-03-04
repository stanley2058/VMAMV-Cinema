#!/bin/bash

mvn install -Dmaven.test.skip=true

cp ./target/ordering-0.0.1-SNAPSHOT.jar .
docker stop Ordering || true
docker rm Ordering || true
docker build -t ordering:latest .
