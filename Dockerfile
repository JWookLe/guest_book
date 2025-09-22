# 1단계: 빌드
FROM gradle:8.10.2-jdk21 AS builder
WORKDIR /usr/src/guest_book

# 의존성 캐시 최적화
COPY build.gradle settings.gradle* gradle.properties* ./
COPY gradle ./gradle
COPY gradlew ./
RUN ./gradlew dependencies --no-daemon || return 0

# 소스 복사 후 빌드
COPY . .
RUN ./gradlew build -x test --no-daemon

# 2단계: 런타임
FROM amazoncorretto:21.0.8
WORKDIR /app
COPY --from=builder /usr/src/guest_book/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
