FROM java:8-jre

ADD ./target/notification-service-1.0.jar /app/

CMD ["java", "-Xmx200m", "-Dserver.port=19999", "-jar", "/app/notification-service-1.0.jar"]
