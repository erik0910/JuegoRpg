/* DELETE 'gameDB' database*/
DROP SCHEMA IF EXISTS DB;
/* DELETE USER 'grupo1' AT LOCAL SERVER*/
DROP USER IF EXISTS 'grupo1'@'localhost';

/* CREATE 'gameDB' DATABASE */
CREATE SCHEMA gameDB;
/* CREATE THE USER 'grupo1' AT LOCAL SERVER WITH PASSWORD 'afterage' */
CREATE USER IF NOT EXISTS 'grupo1'@'localhost' IDENTIFIED BY 'afterage';

GRANT ALL ON messagesDB.* TO 'grupo1'@'localhost';
