FROM openjdk:11
EXPOSE 8001
ADD target/spring-demo-images.jar spring-demo-images.jar
ENTRYPOINT["java","-jar","/spring-demo-images.jar"]

