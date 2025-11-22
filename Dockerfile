FROM eclipse-temurin:17-jdk 

WORKDIR /app

COPY target/mediavault-0.0.1-SNAPSHOT.jar /app/mediavault.jar

EXPOSE 8080

CMD ["java", "-jar", "mediavault.jar"]
