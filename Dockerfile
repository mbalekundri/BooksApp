FROM openjdk:17-jdk-alpine3.13
WORKDIR /app
ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD
COPY target/*.jar /app/booksapp.jar
EXPOSE 8080
RUN mkdir /mytestdir && chmod 777 /mytestdir
CMD ["java", "-jar", "booksapp.jar"]

# Docker build command
# docker build -t rbalekundri/booksapp.jar:1.1 .
# Docker run command
# docker run -d --name rohit-container -e DB_USERNAME=sa -e DB_PASSWORD=pwd -p 8080:8080 rbalekundri/booksapp.jar:1.1
# kubectl exec -it <pod_id> -- sh
