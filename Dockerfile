FROM eclipse-temurin:17-jdk 

WORKDIR /app

COPY target/mediavault-0.0.1-SNAPSHOT.jar /app/mediavault.jar

EXPOSE 8080

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/mediavault
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=admin

CMD ["java", "-jar", "mediavault.jar"]
