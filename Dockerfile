FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y tzdata && rm -rf /var/lib/apt/lists/*
ENV TZ=Asia/Seoul
ENV SPRING_PROFILES_ACTIVE=prod
COPY build/libs/artifact/onTODO-server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]