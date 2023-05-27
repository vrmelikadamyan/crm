## установить базовый образ
#FROM gradle:6.8-jdk11 as build
#
## скопировать файлы Gradle в контейнер и выполнить Gradle сборку
#COPY build.gradle settings.gradle ./
#COPY src ./src/
#
#RUN gradle build --no-daemon
#
## Установите базовый образ
#FROM amazoncorretto:11-alpine-jdk
#
## Установите рабочую директорию
#WORKDIR /app
#
## Копировать сборку приложения из host OS в контейнер
#COPY build/libs/*.jar app.jar
#
## Указываем какой порт приложение будет использовать
#EXPOSE 8080
#
## Команда запуска приложения
#ENTRYPOINT ["java","-jar","app.jar"]


FROM gradle:6.8-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM amazoncorretto:11-alpine-jdk

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]