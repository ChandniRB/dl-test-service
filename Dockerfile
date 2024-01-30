FROM openjdk:17
VOLUME /tmp
EXPOSE 9000
ARG JAR_FILE=target/dl-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]