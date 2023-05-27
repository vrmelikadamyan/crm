# Установите базовый образ
FROM amazoncorretto:11-alpine-jdk

# Установите рабочую директорию
WORKDIR /app

# Копировать сборку приложения из host OS в контейнер
COPY build/libs/*.jar app.jar

# Указываем какой порт приложение будет использовать
EXPOSE 8080

# Команда запуска приложения
ENTRYPOINT ["java","-jar","app.jar"]