# TareaProgramada1
      Creación de un servidor TFTP
Este readme tiene como propósito describir los pasos necesarios del software que se debe instalar para la ejecucción del proyecto y los pasos con detalle.
Estas instrucciones le proporcionarán una copia del proyecto en funcionamiento en su máquina local para fines de desarrollo y prueba. 
	
	Título del Proyecto
Creacion de un servidor TFTP para conexion de N Clientes para transferencia de imagenes Cliente-Servidor

	Prerrequisitos
En este apartado se especifican lo que el usuario requiere para instalar y probar el proyecto:

	Gestor de Base de datos (SQL Server)

	IDE de desarrollo

	Conector de SQL

	JDK

	Descarga de Netbeans
	Paso 1. Ir a la página oficial de descarga y seleccionar el IDE Apache Netbeans en este caso para Windows.
	Pagina: (https://netbeans.org/downloads/8.2/rc/) 
	En la parte derecha superior, se selecciona el idioma o bien utilizar el archivo zip.
   	Haga clic en el botón de descarga. 





	Paso 2. Instalar el JDK antes de empezar la instalar el IDE. Para ello nos vamos a la página oficial de java JDK 11. Se da clic en descargar, se ejecuta el instalador y le aceptar y continuar hasta que finalice.
	Paso 3. Descomprimir la carpeta de descarga de Netbeans y pasar la carpeta Descomprimida a Disco Local C.
	Ve a la pagina: https://www.oracle.com/technetwork/es/java/javase/downloads/index.html 

	Creación del repositorio en Git Hub

	Paso 1. Ir a la esquina derecha superior de la página y selecciona Repositorio Nuevo. Se la da un nombre y se puede agregar una descripción.
	Paso 2. Selecciona iniciar repositorio con un README y da clic en crear repositorio.



	Clonar el repositorio 

	Paso 1. Abre Netbeans y se dirige a la navegación Team, se dirige a la ruta Git/Clone/







	
	Paso 2. Debe poner el link del repositorio y las credenciales del mismo, así como poner la ruta donde se clonará el repositorio, a continuación, dar clic en “Next” y por último en el botón “Finish” 
	

	Creación de la base de datos

	Paso 1. Instalar gestor de base de datos SQL Server, en el siguiente link de descarga: 
		https://www.microsoft.com/es-es/sql-server/sql-server-downloads
	Paso 2. Configurar las credenciales
	Paso 3. Crear la base de datos local e importar el script.
	Paso 4. Crear la conexión en el proyecto.
	Paso 5. En la clase conexión del paquete SQL debe cambiar el usuario y contraseña. 
	Paso 6. Descargar librería, en el siguiente link de descarga: 
			https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
	Paso 7. Descomprimir la librería en alguna carpeta, por ejemplo en Documentos.
	Paso 8. Ir al proyecto, en el paquete "Libraries", le damos clic derecho "Add JAR/Folder" y buscamos la carpeta que descomprimimos hace un rato.
	Paso 9. Seleccionamos la librería mssql-jdbc-9.2.1.jre.8
