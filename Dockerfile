FROM ubuntu:latest 
# Set the working directory
WORKDIR /app
# Copy the calculator.sh script into the container
COPY calculator.sh /app/calculator.sh
