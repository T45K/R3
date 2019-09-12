FROM openjdk:jdk-alpine
VOLUME /tmp
RUN mkdir /app
WORKDIR /app
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar target/internship-0.0.1-SNAPSHOT.jar" ]
