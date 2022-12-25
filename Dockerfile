FROM gradle:7.0.0-jdk11
COPY --chown=gradle:gradle . .
WORKDIR .
RUN gradle build -x test --no-daemon -Dorg.gradle.workers.max=2 
# RUN mvn clean install -DskipTests
EXPOSE 8081
CMD ["gradle", "bootRun --max-workers 4"]