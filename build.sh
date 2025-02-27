#!/bin/bash

mvn package

if [ $? -eq 0 ]; then
    docker-compose up --build
else
    exit 1
fi
