# Tarea Programada 1

Creaci贸n de un servidor TFTP
Este readme tiene como prop贸sito describir los pasos necesarios del software que se debe instalar para la ejecuci贸n del proyecto y los pasos con detalle.

## Comenzando 馃殌

Estas instrucciones le proporcionar谩n una copia del proyecto en funcionamiento en su m谩quina local para fines de desarrollo y prueba. 



### Pre-requisitos 馃搵

En este apartado se especifican lo que el usuario requiere para instalar y probar el proyecto:

-Gestor de Base de datos (SQL Server)

-IDE de desarrollo

-Conector de SQL

-JDK

### Instalaci贸n 馃敡

Paso 1. Ir a la p谩gina oficial de descarga y seleccionar el IDE Apache Netbeans en este caso para Windows.
	P谩gina: (https://netbeans.org/downloads/8.2/rc/) 
	En la parte derecha superior, se selecciona el idioma o bien utilizar el archivo zip.
   	Haga clic en el bot贸n de descarga. 
	
![](https://github.com/corderofallasc/TareaProgramada1/blob/master/Imagenes/1.JPG)

Paso 2. Instalar el JDK antes de empezar la instalar el IDE. Para ello nos vamos a la p谩gina oficial de java JDK 11. Se da clic en descargar, se ejecuta el instalador y le aceptar y continuar hasta que finalice.
	Paso 3. Descomprimir la carpeta de descarga de Netbeans y pasar la carpeta Descomprimida a Disco Local C.
	Ve a la pagina: https://www.oracle.com/technetwork/es/java/javase/downloads/index.html 

### Creaci贸n del repositorio en Git Hub

Paso 1. Ir a la esquina derecha superior de la p谩gina y selecciona Repositorio Nuevo.
	Se la da un nombre y se puede agregar una descripci贸n.
	
Paso 2. Selecciona iniciar repositorio con un README y da clic en crear repositorio.



### Clonar el repositorio 

Paso 1. Abre Netbeans y se dirige a la navegaci贸n Team, se dirige a la ruta Git/Clone/

![](https://github.com/corderofallasc/TareaProgramada1/blob/master/Imagenes/2.JPG)

Paso 2. Debe poner el link del repositorio y las credenciales del mismo, 
	as铆 como poner la ruta donde se clonar谩 el repositorio, a continuaci贸n, dar clic en 鈥淣ext鈥? y por 煤ltimo en el bot贸n 鈥淔inish鈥? 
	

### Creaci贸n de la base de datos

Paso 1. Instalar gestor de base de datos SQL Server, en el siguiente link de descarga: 
		https://www.microsoft.com/es-es/sql-server/sql-server-downloads
	
Paso 2. Configurar las credenciales
	
Paso 3. Crear la base de datos local e importar el script.
	
Paso 4. Crear la conexi贸n en el proyecto.
	
Paso 5. En la clase conexi贸n del paquete SQL debe cambiar el usuario y contrase帽a. 

Paso 6. Descargar librer铆a, en el siguiente link de descarga: 
	https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
	
Paso 7. Descomprimir la librer铆a en alguna carpeta, por ejemplo en Documentos.
	
Paso 8. Ir al proyecto, en el paquete "Libraries", le damos clic derecho "Add JAR/Folder" y buscamos la carpeta que descomprimimos hace un rato.
	
Paso 9. Seleccionamos la librer铆a mssql-jdbc-9.2.1.jre.8

![](https://github.com/corderofallasc/TareaProgramada1/blob/master/Imagenes/3.JPG)




## Construido con 馃洜锔?


* Git: Encargado del controlador de versiones y tareas.

* Java (https://netbeans.org/downloads/8.2/rc/): Lenguaje de programaci贸n.

* SQL (https://www.microsoft.com/es-es/sql-server/sql-server-downloads): Gestor de base de datos.

* Conector de SQL(https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15): Driver para usar SQL en Java. 

## Contribuyendo 馃枃锔?

* Carolina Hern谩ndez Campos B53356

* Christian Cordero Fallas B72283

## Wiki 馃摉

Puedes encontrar mucho m谩s de c贸mo utilizar este proyecto en nuestra [Wiki](https://github.com/tu/proyecto/wiki)

## Versionado 馃搶

* Version jdk: 1.8.0_261

* Version SQL Managment Studio 2019: 15.0.18

* Version IDE: 12.0

* Version conectorSQL: 9.2.1.jrd8

## Autores 鉁掞笍

* **Carolina Hern谩ndez Campos**

[CarolinaHdz]( https://github.com/CarolinaHdz)

* **Christian Cordero Fallas**

[corderofallasc]( https://github.com/corderofallasc)


## Licencia 馃搫

Este proyecto no cuenta con ninguna licencia

## Expresiones de Gratitud 馃巵

* Agradecimiento a Jacob Avila Camacho cuyo c贸digo ha sido consulado: https://youtu.be/wjIXaPW1dy8

* Agradecimiento a DiscoDurodeRoer cuyo c贸digo ha sido consulado: https://www.youtube.com/watch?v=gc6szh6kp8Q


