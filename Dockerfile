# Stage 1: Build
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app

# Copia apenas o pom.xml primeiro (para cache de dependências)
COPY imperium/pom.xml .

# Copia o código-fonte
COPY imperium/src ./src

# Compila o projeto sem testar
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o JAR compilado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
