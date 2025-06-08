# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#FROM alpine:latest

#CMD ["/bin/sh"]

FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/announcement-service.jar announcement-service.jar
ENTRYPOINT ["java", "-jar", "/announcement-service.jar"]
