mvn clean package
docker build -t coordinador .
docker run -d -p 8080:8080 --name coordinador coordinador