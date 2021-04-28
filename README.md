# JuegoRpg

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
