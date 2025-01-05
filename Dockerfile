# Usa una imagen base ligera de Java
FROM openjdk:21-jdk-slim

# Crea un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por tu proyecto al contenedor
COPY target/*.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]