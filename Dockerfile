FROM gradle:7.0.0-jdk11
COPY --chown=gradle:gradle . .
WORKDIR .
RUN gradle build -x test --no-daemon
# RUN mvn clean install -DskipTests
EXPOSE 8081

ENV JAVA_OPTS "${JAVA_OPTS} \
 -Xms10248m\
 -Xmx10248m
"

CMD ["gradle", "bootRun"]