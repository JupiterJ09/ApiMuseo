FROM openjdk:23
VOLUME /tmp
# Copia el archivo JAR al contenedor
COPY /new/target/museo-0.0.1-SNAPSHOT.jar app.jar

# Establece el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
