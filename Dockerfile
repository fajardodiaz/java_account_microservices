FROM amazoncorretto:21-alpine3.17

WORKDIR /app

COPY target/accounts-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]