# ===== STAGE 1: Build =====
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /workspace/app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN ./gradlew dependencies --no-daemon

COPY src src

RUN ./gradlew build -x test --no-daemon

# ===== STAGE 2: Run =====
FROM eclipse-temurin:21-jre-alpine

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

COPY --from=build /workspace/app/build/libs/*.jar app.jar

EXPOSE 8081

# Somente leitura
RUN chown appuser:appgroup app.jar && chmod 600 app.jar

USER appuser

ENTRYPOINT ["java","-jar","app.jar"]

