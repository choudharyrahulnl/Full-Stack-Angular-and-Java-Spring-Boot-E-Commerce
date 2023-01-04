# Dockerfile for maven project
# Version 1.0
# Base image
FROM maven:3-openjdk-17

# Maintainer
MAINTAINER "Rahul Choudhary"

# Copying source code to working directory
COPY . /usr/src/app

# Setting working directory
WORKDIR /usr/src/app

# Building the project
RUN mvn clean install -DskipTests

# Exposing port
EXPOSE 8080

# Running the application
CMD ["java", "-jar", "target/api-1.0.0.jar"]
