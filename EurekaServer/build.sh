#!/bin/bash

mvn clean install

cp ./target/EurekaServer-0.0.1-SNAPSHOT.jar .
docker stop EurekaServer || true
docker rm EurekaServer || true
docker build -t eurekaserver:latest .
