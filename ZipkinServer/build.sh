#!/bin/bash

mvn clean install

cp ./target/zipkinserver-0.0.1-SNAPSHOT.jar .
docker stop ZipkinServer || true
docker rm ZipkinServer || true
docker build -t zipkinserver:latest .
