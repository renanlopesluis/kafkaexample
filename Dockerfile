FROM openjdk:8
ADD target/springboot-kafka-example.jar springboot-kafka-example.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "springboot-kafka-example.jar"]