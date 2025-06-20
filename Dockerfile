FROM openjdk:17

COPY out/artifacts/JavaJuniorPart2_jar/JavaJuniorPart2.jar /tmp/JavaJuniorPart2.jar
WORKDIR /tmp
CMD ["java", "-jar", "/tmp/JavaJuniorPart2.jar"]
