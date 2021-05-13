mvn datanucleus:schema-delete
mvn clean install
mvn datanucleus:enhance
mvn datanucleus:schema-create
mvn exec:java 