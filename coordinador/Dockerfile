FROM openjdk:8-jre-alpine
COPY ./target/coordinador-2.0.2.RELEASE.jar /usr/src/coordinador/
WORKDIR /usr/src/coordinador
EXPOSE 8080
CMD ["java", "-jar", "coordinador-2.0.2.RELEASE.jar"]