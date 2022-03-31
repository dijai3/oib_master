FROM openjdk:11
EXPOSE 8080
COPY target/image_oib_bonus_logic.jar image_oib_bonus_logic.jar
ENTRYPOINT [ "java", "-jar", "/image_oib_bonus_logic.jar"]
