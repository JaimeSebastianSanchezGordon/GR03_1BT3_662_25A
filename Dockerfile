FROM tomcat:10-jre17

# Eliminar aplicaciones predeterminadas de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Crear directorio para datos persistentes de H2
RUN mkdir -p /usr/local/tomcat/data

# Variables de entorno para la aplicación (opcional, puedes configurar esto en hibernate.cfg.xml)
ENV H2_DATA_PATH=/usr/local/tomcat/data/appweb

# Copiar el archivo WAR a la carpeta webapps
COPY target/GR03_1BT3_662_25A.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto de Tomcat
EXPOSE 8080

# Punto de entrada de Tomcat
CMD ["catalina.sh", "run"]