FROM gradle:8.5-jdk21

WORKDIR /.

RUN gradle installDist

CMD ./build/install/app/bin/app
