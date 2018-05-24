mvn clean package
docker build -t dispatcher .
docker run -d -p 9191:9191 --name dispatcher dispatcher