# Use Amazon Corretto 21 with platform specification
FROM --platform=linux/amd64 amazoncorretto:21

WORKDIR /app

# Copy the JAR file from the host to the container
COPY app/build/libs/app.jar /app/app.jar

# Expose the port that your Java service listens on
EXPOSE 9898

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "/app/app.jar"]