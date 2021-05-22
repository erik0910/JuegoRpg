Limpieza de base de datos
mvn datanucleus:schema-delete

Test y reports (Jacoco y ConfPerf)
mvn clean test

Comando para test de Integracion
mvn verify -Pintegracion

Ejecucion de todo el proyecto
mvn clean install
mvn datanucleus:enhance
mvn datanucleus:schema-create
mvn exec:java 