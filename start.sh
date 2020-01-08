#!/bin/bash

docker build -t rozprochy_base .

for d in `ls -d */`
do
	cd $d
	mvn compile jib:dockerBuild
	cd ..
done

docker-compose up -d