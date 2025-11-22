#!/bin/bash

mvn package

if [ $? -eq 0 ]; then
    sudo docker compose up --build
else
    exit 1
fi
