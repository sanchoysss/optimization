FROM openjdk:8-jdk-alpine
RUN mkdir /home/app
COPY /target/bpo-service-0.0.1-SNAPSHOT.jar /home/app
CMD ["java", "-jar", "/home/app/bpo-service-0.0.1-SNAPSHOT.jar"]