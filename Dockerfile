FROM roamingthings/kotlin-native

WORKDIR /usr/src/app

USER root

COPY . /usr/src/app/

RUN ["/usr/src/app/gradlew", "build", "check"]

CMD [ "./gradlew", "build", "check" ]
