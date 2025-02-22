FROM ubuntu:latest
FROM openjdk:11-jdk
# Install dos2unix utility
RUN apt-get update && apt-get install -y dos2unix

# Set the working directory
WORKDIR /app

# Copy the ScientificCalculator.java script into the container
COPY ScientificCalculator.java /app/

# Convert line endings to Unix-style
# RUN dos2unix /app/ScientificCalculator.java

# Ensure the script has execute permissions
RUN javac /app/ScientificCalculator.java

# Set the default command to execute ScientificCalculator.java
 ENTRYPOINT ["java", "/app/ScientificCalculator"]

