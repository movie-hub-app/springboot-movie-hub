FROM openjdk:17
WORKDIR /app
COPY ./target/movie-hub.jar /app
EXPOSE 8080
CMD ["java", "-jar", "movie-hub.jar"]