FROM openjdk:8-jre-alpine
COPY ./target/enrutador-0.1.0.jar /usr/src/enrutador/
WORKDIR /usr/src/enrutador
EXPOSE 8181
CMD ["java", "-jar", "enrutador-0.1.0.jar"]