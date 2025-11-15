# Use a lightweight JDK image
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .

RUN ./mvnw -q -DskipTests package

# Use a smaller JRE for running the app
FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
