FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD CitiesDBService-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
