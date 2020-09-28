FROM openjdk:latest
ADD target/app_docker.jar app_docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app_docker.jar"]