
FROM maven:3.9-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn clean package
EXPOSE 8080
CMD ["java","-jar","target/anime-discovery-1.0.jar"]
