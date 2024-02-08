FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/store-service-0.0.1-SNAPSHOT.jar storeApp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/storeApp.jar"]