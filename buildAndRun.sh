#!/bin/bash
cd product-microservice
./mvnw clean install dockerfile:build
cd ..
docker-compose up

