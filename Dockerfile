FROM openjdk:17
WORKDIR /devops
COPY ./target/classtwo-docker.jar /devops
EXPOSE 8091
CMD ["java", "-jar", "classtwo-docker.jar"]