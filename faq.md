# Preguntas Frecuentes

## Archivos a utilizar
* [Talend Data Integration](https://info.talend.com/trial-talend-data-integration.html)
* [Power BI](https://go.microsoft.com/fwlink/?LinkId=521662&clcid=0x409)

## Errores con **Talend Data Integration** en MacOS

1) A la hora de instalar **Talend**, llegan al momento de las políticas de privacidad y no les permite presionar en Aceptar, se congela la pantalla deben hacer lo siguiente:

* Instalar [Java JDK 1.8_151](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html#thankYouDivjdk-8u151-oth-JPR)
* Modificar TOS_DI-macosx-cocoa.app/Contents/Info.plist agregando la línea para forzar la utilización del JDK 1.8_151. 
	* Para poder acceder, en el archivo *TOS_DI-macosx-cocoa.app* hacer botón derecho 
	* "Mostrar contenido del paquete"
	* Editar el archivo Info.plist

``` plist
<key>Eclipse</key>
<array>
	<string>-vm</string><string>/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/bin/java</string>
	...
</array>
```

2) Un error común a la hora de ejecutar el **Talend** es que que nos muestre el siguiente mensaje:

> tos_di-macosx-cocoa executable launcher was unable to locate its companion shared library

Para poder solucionar dicho problema, lo que debemos hacer es lo siguiente:
* Abrir una terminal (Command + Espacio) y escribir Terminal
* Luego cuando nos aparece la ventana negra, debemos escribir lo siguiente
> nombre-de-mi-mac$ /path-to-your-talend-open-studio-folder$ xattr -d com.apple.quarantine *

* Una vez ejecutado el comando intentar abrir el **Talend** para ver si funciona.

*Más información en [link](https://community.talend.com/t5/Installing-and-Upgrading/executable-launcher-was-unable-to-locate-its-companion-shared/td-p/25582)*

## Errores con Power BI en Windows 8 (VirtualBox)

1) Si a la hora de abrir el **Power BI** les aparece un mensaje que dice:

> Solved: error value 'preferred'

Deben realizar los siguientes pasos para solucionar las problemáticas:

* Deben instalar en su Windows 8 el **MySQL Connector/Net 6.0.x for Microsoft Windows**. Es muy importante la versión para que no tengan problemas.


## Inconvenientes generales

1) Si queremos conectarnos a una base de datos SQL localmente desde nuestra Máquina Virtual y no podemos, seguramente la solución sea la siguiente:

* Ingresar en el archivo my.cnf generado por MySQL, ejemplo:
> $ sudo vim /usr/local/etc/my.cnf
* Dentro del archivo *my.cnf* deben modificar la dirección IP 127.0.0.1 por 0.0.0.0 de la siguiente manera:

``` cnf
# Default Homebrew MySQL server config
[mysqld]
# Only allow connections from localhost
bind-address = 0.0.0.0
```
* Una vez modificado guardar y reiniciar el MySQL.
> $ sudo mysql.server restart

2) ¿Problemas de permisos para acceder a la base de datos local? Un problema muy común es el tema de permisos que tiene nuestra base de datos, entones lo que deberán hacer es crear un nuevo usuario y contraseña para darle permisos.

* Primero ingresar en MySQL Server
> $ mysql
* Dentro de la termina del MySQL Server, deben ejecutar el siguiente comnado:
> mysql> GRANT ALL PRIVILEGES ON *.* TO 'nombredeusuario'@'%' IDENTIFIED BY 'password';
y como resultado debe aparecer un mensaje así:
> Query OK, 0 rows affected, 1 warning (0.14 sec)