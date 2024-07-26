FROM maven:3.9.8 as build
WORKDIR /app
COPY . .
RUN mvn dependency:resolve
COPY src ./src
RUN mvn clean package

FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]