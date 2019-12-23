FROM openjdk:8-jdk-alpine
MAINTAINER Somi_J "somireddy.jonnala@gmail.com"
COPY TestSp-0.0.1-SNAPSHOT.jar .
ENTRYPOINT java -jar /TestSp-0.0.1-SNAPSHOT.jar