[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 01`](../Readme.md) > `Reto 1`
	
## Reto 1

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Cambiar el ícono por defecto en un proyecto Android.
- Modificar el layout por default en un proyecto Android.
- Agregar un texto programáticamente. 

### 2. Requisitos :clipboard:

1. Android Studio instalado
2. Al menos un Emulador android configurado

### 3. Desarrollo :computer:

Sustituye los icon launcher en los directorios mipmap por íconos personalizados. Puedes acceder a los archivos zip con los íconos para reemplazar o crear los propios.


* Los íconos los encuentras en [este Archivo](ic_launcher.zip)
* La versión redondeada de los íconos está en [este Archivo](ic_launcher_round.zip)

* Si decides crear tus propios recursos puedes utilizar [esta Herramienta](https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html#foreground.type=clipart&foreground.clipart=android&foreground.space.trim=1&foreground.space.pad=0.25&foreColor=rgba(96%2C%20125%2C%20139%2C%200)&backColor=rgb(68%2C%20138%2C%20255)&crop=0&backgroundShape=square&effects=none&name=ic_launcher).

__Hint:__ Elimina la carpeta ___mipmap-anydpi-26___.


2. Entrar a _res/values/strings.xml_ y modificar el texto entre los tags de string. Correr la app nuevamente y comentar el resultado.


3. Abre el archivo **activity_main.xml** dentro de *res/layouts* y selecciona el texto (TextView)  en el preview de la pantalla. Checa la columna  _Attributes_ y modifica el campo _text_.

4. Arrastra a cualquier parte de la pantalla un elemento Button y corre el proyecto.  ¿Qué sucede?

<br/>

[`Anterior`](../Ejemplo-03/Readme.md) | [`Siguiente`](../Ejemplo-04/Readme.md)

</div>
