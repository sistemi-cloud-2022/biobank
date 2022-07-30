FROM openjdk:11-slim
WORKDIR /app
COPY target/biobank-0.0.1-SNAPSHOT.jar /app
ENV SERVER_PORT 5000
EXPOSE $SERVER_PORT
CMD ["java", "-jar", "biobank-0.0.1-SNAPSHOT.jar" ]