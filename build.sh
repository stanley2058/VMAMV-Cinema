#!/bin/bash


## Prebuild
cd vmamv-eureka-client
./build.sh
cd ..

cd vmamv-service-client
./build.sh
cd ..

## Build
cd ZipkinServer
./build.sh
cd ..

cd EurekaServer
./build.sh
cd ..

cd Payment
./build.sh
cd ..

cd Notification
./build.sh
cd ..

cd Ordering
./build.sh
cd ..

cd CinemaCatalog
./build.sh
cd ..

cd GroceryInventory
./build.sh
cd ..

cd Cinema
./build.sh
cd ..
