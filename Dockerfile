FROM openjdk:17-jdk-alpine3.13
WORKDIR /app
ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD
COPY target/*.jar /app/booksapp.jar
EXPOSE 8080
CMD ["java", "-jar", "booksapp.jar"]

# Docker build command
# docker build -t rbalekundri/booksapp.jar:1.0 .
# Docker run command
# docker run -p 8080:8080 -e DB_USERNAME=sa -e DB_PASSWORD=pwd rbalekundri/booksapp.jar:1.0