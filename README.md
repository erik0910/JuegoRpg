# JuegoRpg

[![Build Status](https://travis-ci.com/erik0910/JuegoRpg.svg?branch=main)](https://travis-ci.com/erik0910/JuegoRpg)

## Requisitos:

Se debe tener instalado para el correcto funcionamiento:

-Maven 3.6.3

-JUnit 4

-OpenJDK 15

-XAMPP (Para iniciar la parte servidora)

**Ejecución de test:**

Para ejecutar los test unitarios se debe usar el comando: ```mvn clean test```

Con ello dentro del directorio "target/site/jacoco" esta "index.html" que te muestra el coverage del proyecto.
Además, dentro de "target/contiperf-report" existe otro "index.html" para mostrar los test de rendimiento y sus resultados.

Para la ejecucion de la parte de integración se debe usar el comando: ```mvn verify -Pintegracion```

**Configuración previa:**

Para inicializar el servidor MySQL debemos introducir las siguientes sentencias dentro del administrador de XAMPP en la parte de SQL:
```
DROP SCHEMA IF EXISTS gamedb;
DROP USER IF EXISTS 'rpg'@'localhost';

CREATE SCHEMA gamedb;
CREATE USER IF NOT EXISTS 'rpg'@'localhost' IDENTIFIED BY 'rpg';

GRANT ALL ON gamedb.* TO 'rpg'@'localhost';
```

Tambien se debe arrancar la parte de Apache pulsando el boton "Start" al igual que en MySQL.

**Configuración:**

 Para la correcta inicialización del juego se deben seguir los siguientes pasos en orden y un por uno:

**1.** Descargar el zip del proyecto.

**2.** Descomprimir el .zip en la carpeta que se desee.

**3.** Abrir la carpeta descomprimida (JuegoRpg-main).

**4.** Seleccionar la carpeta RPG.

**5.** Estando en la carpeta RPG, escribir en la barra del buscador de archivos ```cmd```.

**6.** A continuación se abrira la consola de comandos, escriba en orden estos comandos: 
```
mvn clean install 
mvn datanucleus:enhance 
mvn datanucleus:schema-create 
```

**7.** Si todo funciona bien, deberia de terminar la compilación sin mostrar ningun error.

**8.** Una vez acabado este paso introduzca el siguiente comando ```mvn exec:java```.

**9.** Ahora cargara la ventana principal del juego y podra jugar sin problemas.

**10.** Si quiere limpiar la base de datos use este comando ```mvn datanucleus:schema-delete```.
