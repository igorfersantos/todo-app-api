FROM gradle:7.0.0-jdk11
COPY --chown=gradle:gradle . .
WORKDIR .
RUN gradle clean build -x test --no-daemon
# RUN mvn clean install -DskipTests
EXPOSE 8081
ENV postgresql://${{ PGUSER }}:${{ PGPASSWORD }}@${{ PGHOST }}:${{ PGPORT }}/${{ PGDATABASE }}
CMD ["gradle", "bootRun"]