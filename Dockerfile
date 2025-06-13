# Stage 1: Build
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

COPY gradlew build.gradle settings.gradle ./
COPY gradle ./gradle

COPY src ./src

COPY .env .env

RUN chmod +x ./gradlew

RUN ./gradlew clean build -x test --no-daemon --stacktrace

# Stage 2: Runtime
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]


