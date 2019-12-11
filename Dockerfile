FROM anapsix/alpine-java:8

RUN apk update
RUN apk add curl jq
COPY wait.sh /wait.sh