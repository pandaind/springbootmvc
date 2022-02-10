FROM openjdk:8-jdk-alpine
MAINTAINER Chittaranjan Panda <chittaranjan@hotmail.com>
EXPOSE 8080
ADD target/*.jar app.jar
ENTRYPOINT ["sh","-c","java -jar /app.jar"]