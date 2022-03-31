FROM openjdk:11 as base
EXPOSE 8080
# COPY target/image_oib_bonus_logic.jar image_oib_bonus_logic.jar
# ENTRYPOINT [ "java", "-jar", "/image_oib_bonus_logic.jar"]
# FROM openjdk:16-alpine3.13

COPY ./target/image_oib_bonus_logic.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
