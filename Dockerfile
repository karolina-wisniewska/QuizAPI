FROM openjdk:17-alpine3.14

RUN apk update && apk upgrade && \
    apk add \
    git \
    maven

RUN mkdir /code
COPY ./ /code
RUN cd /code && \
     mvn package && \
     mkdir /opt/app && \
     mv /code/target/RecruitmentTask-0.0.1-SNAPSHOT.jar /opt/app && \
     cd / && \
     rm -r /code

RUN apk del \
    git \
    maven

EXPOSE 8080

WORKDIR /opt/app

CMD java -jar /opt/app/RecruitmentTask-0.0.1-SNAPSHOT.jar
