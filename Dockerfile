FROM ubuntu:latest 

# Set the working directory
WORKDIR /app

# Copy the calculator.sh script into the container
COPY calculator.sh /app/calculator.sh

# Ensure the script has execute permissions
RUN chmod +x /app/calculator.sh

# Set the default command to execute calculator.sh
CMD ["bash", "/app/calculator.sh"]
