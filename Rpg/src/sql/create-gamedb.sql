/* DELETE 'gamedb' database*/
DROP SCHEMA IF EXISTS gamedb;
/* DELETE USER 'rpg' AT LOCAL SERVER*/
DROP USER IF EXISTS 'rpg'@'localhost';

/* CREATE 'gamedb' DATABASE */
CREATE SCHEMA gamedb;
/* CREATE THE USER 'rpg' AT LOCAL SERVER WITH PASSWORD 'rpg' */
CREATE USER IF NOT EXISTS 'rpg'@'localhost' IDENTIFIED BY 'rpg';

GRANT ALL ON gamedb.* TO 'rpg'@'localhost';
