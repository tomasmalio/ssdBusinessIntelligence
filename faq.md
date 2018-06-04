# Sistema de Soporte a las Decisiones - Trabajo Práctico BI

**Profesor:** Pablo Sciolla

**Universidad:** UADE

Tomar la base de datos Neptuno (entregada en clase) en formato Access y desarrollar un modelo analítico que satisfaga las necesidades de una aplicación analítica planteada en el párrafo Aplicación.

## Errores comunes en MacOS

1) A la hora de instalar Talend, llegan al momento de las políticas de privacidad y no les permite presionar en Aceptar, se congela la pantalla deben hacer lo siguiente:


> Instalar Java JDK 1.8_151
> Modificar TOS_DI-macosx-cocoa.app/Contents/Info.plist agregando la línea para formzar la utilización del JDK 1.8_151. Para poder acceder, en el archivo *TOS_DI-macosx-cocoa.app* hacer botón derecho, "Mostrar contenido del paquete"
``` plist
<key>Eclipse</key>
<array>
	<string>-vm</string><string>/Library/Java/JavaVirtualMachines/jdk1.8.0_151.jdk/Contents/Home/bin/java</string>
	...
</array>
```