FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/eureka-service-0.0.1-SNAPSHOT.jar /Eureka-service.jar
CMD ["java","-jar","Eureka-service.jar","--spring.profiles.active=prod"]
EXPOSE 8761
