FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Gateway-0.0.1-SNAPSHOT.jar /Gateway-service.jar
CMD ["java","-jar","Gateway-service.jar","--spring.profiles.active=prod"]
EXPOSE 9999
