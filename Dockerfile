FROM openjdk:11
EXPOSE 8001
ADD target/spring-boot-0.0.1-SNAPSHOT.jar spring-boot-0.0.1-SNAPSHOT.jar
ENTRYPOINT["java","-jar","/spring-boot-0.0.1-SNAPSHOT.jar"]

