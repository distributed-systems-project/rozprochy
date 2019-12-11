#!/bin/bash

HOST=$1
COUNTER=0
while [ "$(curl -s "$HOST"/actuator/health | jq -r .status)" != "UP" ]
do
  sleep 1
  echo "Waiting for dependency $HOST for $COUNTER [s]"
  COUNTER=$((COUNTER+1))
done

echo "$HOST discovered up after waiting $COUNTER [s]"
