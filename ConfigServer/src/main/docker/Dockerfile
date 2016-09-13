FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD serviceconfigserver-0.0.1.jar app.jar
EXPOSE 8888
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
