FROM openjdk:17-jdk-alpine3.13
WORKDIR /app
ENV H2-DB-USERNAME=$H2-DB-USERNAME
ENV H2-DB-PASSWORD=$H2-DB-PASSWORD
COPY target/*.jar /app/booksapp.jar
EXPOSE 8080
RUN mkdir /mytestdir && chmod 777 /mytestdir
CMD ["java", "-jar", "booksapp.jar"]

# Docker build command
# docker build -t rbalekundri/booksapp.jar:1.1 .
# Docker run command
# docker run -d --name rohit-container -e H2-DB-USERNAME=sa -e H2-DB-PASSWORD=pwd -p 8080:8080 rbalekundri/booksapp.jar:1.1
# With vault config: docker run -d --name rohit-container -p 8080:8080 rbalekundri/booksapp.jar:1.1
# kubectl exec -it <pod_id> -- sh
