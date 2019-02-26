FROM roamingthings/kotlin-native

WORKDIR /usr/src/app

USER root

RUN git clone git://git.drogon.net/wiringPi && cd wiringPi && ./build


COPY . /usr/src/app/

RUN ["/usr/src/app/gradlew", "build", "check"]

CMD [ "./gradlew", "build", "check" ]
