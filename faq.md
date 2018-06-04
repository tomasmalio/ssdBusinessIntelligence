# Preguntas Frecuentes

## Archivos a utilizar
* [Talend Data Integration](https://info.talend.com/trial-talend-data-integration.html)
* [Power BI](https://go.microsoft.com/fwlink/?LinkId=521662&clcid=0x409)

## Errores con **Talend Data Integration** en MacOS

1) A la hora de instalar **Talend*, llegan al momento de las políticas de privacidad y no les permite presionar en Aceptar, se congela la pantalla deben hacer lo siguiente:

* Instalar Java JDK 1.8_151
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

2) Un error común a la hora de ejecutar el *Talend* es que que nos muestre el siguiente mensaje:

> tos_di-macosx-cocoa executable launcher was unable to locate its companion shared library

Para poder solucionar dicho problema, lo que debemos hacer es lo siguiente:

https://community.talend.com/t5/Installing-and-Upgrading/executable-launcher-was-unable-to-locate-its-companion-shared/td-p/25582

* Abrir una terminal (Command + Espacio) y escribir Terminal
* Luego cuando nos aparece la ventana negra, debemos escribir lo siguiente
> nombre-de-mi-mac$ /path-to-your-talend-open-studio-folder$ xattr -d com.apple.quarantine *

* Una vez ejecutado el comando intentar abrir el **Talend** para ver si funciona.


## Errores con Power BI en Windows 8 (VirtualBox)

1) Si a la hora de abrir el *Power BI* les aparece un mensaje que dice:

> Solved: error value 'preferred'

Deben realiar los siguientes pasos para solucionar las problemáticas:

* Deben instalar en su Windows 8 el **MySQL Connector/Net 6.0.x for Microsoft Windows**. Es muy importante la versión para que no tengan problemas.