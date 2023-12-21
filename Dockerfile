# Usa una imagen base de Wildfly
FROM jboss/wildfly:latest

# Copia el archivo WAR construido en el target del proyecto a la carpeta de despliegue de Wildfly
COPY target/tu-proyecto.war /opt/jboss/wildfly/standalone/deployments/

# Expone el puerto 8080 para la aplicación desplegada en Wildfly
EXPOSE 8081

# Comando para ejecutar Wildfly al iniciar el contenedor
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
