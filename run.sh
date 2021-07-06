#!/bin/bash

PREFIX=http://
HOST=140.121.197.128

VMAMV_Port=4147
VMAMV_Image=vmamvs-image
ZIPKIN_Port=9411
ZIPKIN_URI=$HOST:$ZIPKIN_Port


docker run --restart=always -d -p 9411:9411 -e "TZ=Asia/Taipei" --name ZipkinServer zipkinserver:latest

sleep 20s

docker run --restart=always -d -p 4140:4140 -e "TZ=Asia/Taipei" --name EurekaServer eurekaserver:latest

echo "Waiting For Eureka Server..."
sleep 30s

docker run -d -p $VMAMV_Port:$VMAMV_Port \
           -e ZIPKIN=$PREFIX$HOST:$ZIPKIN_Port \
           -e PORT=$VMAMV_Port --name VMAMVS $VMAMV_Image:latest

echo "Waiting For VMAMV Server..."
sleep 30s

docker container restart pdas-eureka-eureka-server
sleep 30s

docker run --restart=always -d -p 4106:4106 -e "TZ=Asia/Taipei" --name Payment payment:latest
docker run --restart=always -d -p 4102:4102 -e "TZ=Asia/Taipei" --name Notification notification:latest

sleep 30s

docker run --restart=always -d -p 4105:4105 -e "TZ=Asia/Taipei" --name Ordering ordering:latest

sleep 30s

docker run --restart=always -d -p 4103:4103 -e "TZ=Asia/Taipei" --name GroceryInventory groceryinventory:latest
docker run --restart=always -d -p 4104:4104 -e "TZ=Asia/Taipei" --name CinemaCatalog cinemacatalog:latest
docker run --restart=always -d -p 4107:4107 -e "TZ=Asia/Taipei" --name Cinema cinema:latest
