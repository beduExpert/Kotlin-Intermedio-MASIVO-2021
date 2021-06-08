[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 01`](../Readme.md) > `Reto 1`
	
## Reto 1

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Cambiar el ícono por defecto
- Modificar el layout por default
- Agregar un texto programáticamente 

### 2. Requisitos :clipboard:

1. Android Studio instalado
2. Al menos un Emulador android configurado

### 3. Desarrollo :computer:

1. Sustituir los icon launcher en los directorios _mipmap_ por íconos personalizados. Puedes acceder a los archivos zip con los íconos para reemplazar o crear los propio.


* Los íconos los encuentras en [Este Archivo](ic_launcher.zip)
* La versión redondeada de los ínconos están en [Este Archivo](ic_launcher_round.zip)

* Si decides crear tus propios recursos, utiliza [Esta Herramienta](https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html#foreground.type=clipart&foreground.clipart=android&foreground.space.trim=1&foreground.space.pad=0.25&foreColor=rgba(96%2C%20125%2C%20139%2C%200)&backColor=rgb(68%2C%20138%2C%20255)&crop=0&backgroundShape=square&effects=none&name=ic_launcher).

__Hint:__ Elimina la carpeta ___mipmap-anydpi-26___.



<details><summary>Solución</summary>
<p>
Visualizar el proyecto en modo Project.
	
![imagen](images/01.png)

Reemplazar en cada directorio mipmap tanto los archivos ic_launcher como ic_launcher_round

Eliminar la carpeta mipmap-anydpi-26

Correr nuevamente el proyecto.

El resultado: ícono renovado

![imagen](images/00.png)

</p>
</details>
<br/>

2. Entrar a _res/values/strings.xml_ y modificar el texto entre los tags de string. Correr la app nuevamente y comentar el resultado.

<details><summary>Solución</summary>
<p>

Modificar el texto de la string app_name

![imagen](images/02.png)

El cambio sucede tanto en el título del launcher de la aplicación, como de la AppBar.

![imagen](images/03.png)

![imagen](images/04.png)

</p>
</details>
<br/>

3. Abre el archivo **activity_main.xml** dentro de *res/layouts* y selecciona el texto (TextView)  en el preview de la pantalla. Checa la columna  _Attributes_ y modifica el campo _text_.

4. Arrastra a cualquier parte de la pantalla un elemento Button y corre el proyecto. Qué sucede?

<details><summary>Solución</summary>
<p>

El paso 3 modifica el Texto del TextView 

Mientras que el paso 4 (Arrastrar el botón) provoca que salga un botón en pantalla, pero este se alineará a la esquina superior izquierda (el por qué se aborda en otro tema).

![imagen](images/05.png)


</p>
</details>
<br/>

[`Anterior`](../Ejemplo-03/Readme.md) | [`Siguiente`](../Ejemplo-04/Readme.md)

</div>
