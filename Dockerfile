FROM maven:3.6.2-jdk-8 as maven
WORKDIR /app

COPY pom.xml .
COPY src src
RUN mvn -B clean package -DskipTests=true
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jre-alpine
ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
ARG DEPENDENCY=/app/target/dependency
COPY --from=maven ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=maven ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=maven ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","-Djava.security.egd=file:/dev/./urandom","com.github.haappyy.qrcodegenerator.JsonPathServiceApplication"]