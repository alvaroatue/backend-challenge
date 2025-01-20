# Usa Amazon Corretto 21 como imagen base
FROM amazoncorretto:21-alpine-jdk

COPY target/backend-challenge-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]