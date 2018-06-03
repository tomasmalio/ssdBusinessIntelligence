# Sistema de Soporte a las Decisiones - Trabajo Práctico BI
### Profesor: Pablo Sciolla
### Universidad: UADE

Tomar la base de datos Neptuno (entregada en clase) en formato Access y desarrollar un modelo analítico que satisfaga las necesidades de una aplicación analítica planteada en el párrafo Aplicación.

## Comienzo
Para poder correr y utilizar el proyecto lo primero que debemos hacer es seguir los siguientes pasos:

1) Debemos crear la base de datos (ssd) que se encuentra en la primer línea del archivo (SQL/sistema-de-soporte.sql) o ejecutar la siguiente sentencia:

	CREATE DATABASE ssd;

2) Luego, debemos cargar información por default de toda la aplicación:
	ciudades
	paises
	fechas

	Para ello debemos importar en nuestro servidor MySQL los archivos respectivamente:
	SQL/ciudades.sql
	SQL/paises.sql
	SQL/fechas.sql

3) Una vez que finalizamos el proceso de carga de información default del programa, vamos a pasar a crear nuestras tablas del modelo de dimensiones:
	
	cliente
	categoria
	proveedor
	empleado
	formaDeEnvio
	producto
	factventa
	factpresupuesto

	Para realizar dicho procedimiento, debemos importar el archivo (SQL/sistema-de-soporte.sql) en nuestro MySQL.

4) Ahora que tenemos cargado nuestro base de datos podremos ejecutar nuestro ETL en Talend para que cargue la información. Para realizarlo, debemos abrir nuestro sistema Talend, y luego importar el proyecto (SSD/ETL/talend.project)

5) Dentro de nuestro ETL, podremos encontrar que hay 3 jobs creados.
	1- Generacion de Dimnensiones
	2- Generación Fact Venta
	3- Generación Fact Presupuesto

	Si deseamos procesarlo hay que ejecutarlo en ese orden a fin de conseguir un buen resultado.

6) Finalizado el proceso de carga, ahora podemos abrir nuestro Power BI para visualizar la información generada. Para ello, debemos importar nuestro archivo pbit que se encuentra en Visualizacion/ssd-version2.pbit

IMPORTANTE: la conexión de la base de datos fue realizada a ssd.local, si se ha cambiado la url debemos modificar la conexión.

## Requisitos
1) Power BI tiene conflictos con los nuevos MySQL Connector, a si que si nos encontramos con un error que dice: Solved: error value 'preferred' no desesperen, deben hacer lo siguiente: Borrar nuestro MySQL Connect que tinenen instalado e instalar MySQL Connector/Net 6.0.x for Microsoft Windows
Si necesitan más información les recomiendo el siguiente link: https://community.powerbi.com/t5/Integrations-with-Files-and/Trying-to-connect-to-MY-SQL-from-Power-BI/m-p/195482#M10931
