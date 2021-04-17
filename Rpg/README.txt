mvn clean install
mvn datanucleus:enhance
mvn datanucleus:schema-create
mvn exec:java 

mvn datanucleus:schema-delete
