FROM openjdk:11-jdk-stretch

VOLUME /tmp
COPY target/holiday-extras-api-task-0.0.1-SNAPSHOT.war app.jar
ENTRYPOINT ["java","-jar","/app.jar"]