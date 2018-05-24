mvn clean package
docker build -t enrutador .
docker run -d -p 8181:8181 --name enrutador enrutador