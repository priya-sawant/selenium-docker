FROM openjdk:8u191-jre-alpine3.8

#workspace
WORKDIR /usr/selenium/docker


#add .jar under target from host into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

ADD healthcheck.sh healthcheck.sh


#add suite files
ADD testng.xml testng.xml

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG testng.xml
