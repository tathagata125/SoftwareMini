FROM openjdk:11-jdk

# Set the working directory
WORKDIR /app

# Copy the ScientificCalculator.java script into the container
COPY ScientificCalculator.java /app/

# Ensure the script has execute permissions
RUN javac /app/ScientificCalculator.java

# Set the default command to execute ScientificCalculator.java
CMD ["java", "ScientificCalculator"]