FROM openjdk:8-jre-alpine
COPY ./target/dispatcher-0.0.1-SNAPSHOT.jar /usr/src/dispatcher/
WORKDIR /usr/src/dispatcher
EXPOSE 9191
CMD ["java", "-jar", "dispatcher-0.0.1-SNAPSHOT.jar"]