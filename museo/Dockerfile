# Usamos la imagen de OpenJDK
FROM openjdk:23

# Establecemos el volumen /tmp para datos temporales
VOLUME /tmp

# Copiamos el archivo JAR al contenedor
COPY target/museo-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
