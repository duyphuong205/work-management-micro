FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/discovery-server-0.0.1-SNAPSHOT.war /app/discovery-server.war
EXPOSE 8761
CMD ["java", "-jar", "discovery-server.war"]