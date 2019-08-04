FROM openjdk:11-jdk-slim

VOLUME /tmp

COPY target/holiday-extras-api-task-0.0.1-SNAPSHOT.war app.jar

CMD ["java", "-jar", "/app.jar"]