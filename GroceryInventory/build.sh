#!/bin/bash

mvn clean test -Dmaven.test.failure.ignore=true
mvn install -Dmaven.test.skip=true

cp ./target/groceryinventory-0.0.1-SNAPSHOT.jar .
docker stop GroceryInventory || true
docker rm GroceryInventory || true
docker build -t groceryinventory:latest .
