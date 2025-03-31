FROM gradle:8.7-jdk-21-and-22-alpine AS build
WORKDIR /workspace/app
COPY . .

#Run compile phase and skip tests
RUN gradle clean build -x test

FROM amazoncorretto:21-alpine
COPY --from=build /workspace/app/build/libs/*-SNAPSHOT.jar ./app.jar

CMD ["java", "-jar", "app.jar"]