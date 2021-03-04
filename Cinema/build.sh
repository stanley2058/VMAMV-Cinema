#!/bin/bash

mvn clean install

cp ./target/cinema-1.jar .
docker stop Cinema || true
docker rm Cinema || true
docker build -t cinema:latest .
