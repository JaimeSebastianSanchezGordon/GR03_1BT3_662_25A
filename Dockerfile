FROM tomcat:10-jre17

# Eliminar aplicaciones predeterminadas de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Crear directorio para datos persistentes e instalar SQLite
RUN mkdir -p /usr/local/tomcat/data && \
    apt-get update && \
    apt-get install -y sqlite3 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Variables de entorno para la aplicación
ENV DB_PATH=/usr/local/tomcat/data/GR03_1BT3_662_25A.db

# Copiar el archivo WAR a la carpeta webapps
COPY target/GR03_1BT3_662_25A.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto de Tomcat
EXPOSE 8080

# Punto de entrada de Tomcat
CMD ["catalina.sh", "run"]

#Hola Mundo