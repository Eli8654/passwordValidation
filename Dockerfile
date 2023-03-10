FROM openjdk:11

ARG JAR_FILE=build/libs/security*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

ENV SERVER_PORT=8080

EXPOSE 8080