# TareaProgramada1
      Creaci�n de un servidor TFTP
Este readme tiene como prop�sito describir los pasos necesarios del software que se debe instalar para la ejecucci�n del proyecto y los pasos con detalle.
Estas instrucciones le proporcionar�n una copia del proyecto en funcionamiento en su m�quina local para fines de desarrollo y prueba. 
	
	T�tulo del Proyecto
Creacion de un servidor TFTP para conexion de N Clientes para transferencia de imagenes Cliente-Servidor

	Prerrequisitos
En este apartado se especifican lo que el usuario requiere para instalar y probar el proyecto:

	Gestor de Base de datos (SQL Server)

	IDE de desarrollo

	Conector de SQL

	JDK

	Descarga de Netbeans
	Paso 1. Ir a la p�gina oficial de descarga y seleccionar el IDE Apache Netbeans en este caso para Windows.
	Pagina: (https://netbeans.org/downloads/8.2/rc/) 
	En la parte derecha superior, se selecciona el idioma o bien utilizar el archivo zip.
   	Haga clic en el bot�n de descarga. 





	Paso 2. Instalar el JDK antes de empezar la instalar el IDE. Para ello nos vamos a la p�gina oficial de java JDK 11. Se da clic en descargar, se ejecuta el instalador y le aceptar y continuar hasta que finalice.
	Paso 3. Descomprimir la carpeta de descarga de Netbeans y pasar la carpeta Descomprimida a Disco Local C.
	Ve a la pagina: https://www.oracle.com/technetwork/es/java/javase/downloads/index.html 

	Creaci�n del repositorio en Git Hub

	Paso 1. Ir a la esquina derecha superior de la p�gina y selecciona Repositorio Nuevo. Se la da un nombre y se puede agregar una descripci�n.
	Paso 2. Selecciona iniciar repositorio con un README y da clic en crear repositorio.



	Clonar el repositorio 

	Paso 1. Abre Netbeans y se dirige a la navegaci�n Team, se dirige a la ruta Git/Clone/







	
	Paso 2. Debe poner el link del repositorio y las credenciales del mismo, as� como poner la ruta donde se clonar� el repositorio, a continuaci�n, dar clic en �Next� y por �ltimo en el bot�n �Finish� 
	

	Creaci�n de la base de datos

	Paso 1. Instalar gestor de base de datos SQL Server, en el siguiente link de descarga: 
		https://www.microsoft.com/es-es/sql-server/sql-server-downloads
	Paso 2. Configurar las credenciales
	Paso 3. Crear la base de datos local e importar el script.
	Paso 4. Crear la conexi�n en el proyecto.
	Paso 5. En la clase conexi�n del paquete SQL debe cambiar el usuario y contrase�a. 
	Paso 6. Descargar librer�a, en el siguiente link de descarga: 
			https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
	Paso 7. Descomprimir la librer�a en alguna carpeta, por ejemplo en Documentos.
	Paso 8. Ir al proyecto, en el paquete "Libraries", le damos clic derecho "Add JAR/Folder" y buscamos la carpeta que descomprimimos hace un rato.
	Paso 9. Seleccionamos la librer�a mssql-jdbc-9.2.1.jre.8
