FROM openjdk:11
ADD target/news-page.jar news-page.jar
ENTRYPOINT ["java", "-jar","news-page.jar"]