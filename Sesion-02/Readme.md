[`Kotlin-Intermedio`](../Readme.md) > `Sesión 2`


## Sesión 2: Views

### 1. Objetivos :dart: 

---

<img src="../images/android-kotlin.png" align="right" height="120" hspace="10">

- Modificar el proyecto por defecto.
- Utilizar los controles esenciales para generar interfaces básicas.
- Utilizar herramientas básicas para debuggeo.

---

<div style="text-align: justify;">


### Instrucciones de la sesión

Para esta sesión, modificaremos el layout inicial de un proyecto creado, de modo que el archivo generado en ___res/layout___ sea reemplazado por el siguiente código:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:gravity="center"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

     <!-- {COLOCA AQUI EL CONTENIDO DEL LAYOUT} -->
     
</LinearLayout>
```

Más adelante entenderemos qué hace cada línea. Por ahora es importante agregarlo para el funcionamiento del proyecto.

### Introducción

Un ___View___ es una clase que representa la base de todos los componentes para la interfaz gráfica y su representación gráfica está delimitada por un rectángulo. Es como el lienzo sobre el cual vamos a dibujar todos loe elementos gráficos de nuestra app, pero representado mediante código.

La descripción gráfica de un View así como su posición en la pantalla está determinado por un archivo layout en lenguaje XML, y se encuentran distribuidos jerárquicamente en un árbol de Vistas. 

Un tipo especial de View es el ___ViewGroup___, que es un contenedor de Views y otros ViewGroups con un formato de orden específico. 

<img src="images/view_tree.png" align="right">
<h5>Ejemplo de árbol de Views</h5>

Dentro de cada __View__ en la jerarquía se agregan los elementos que la conforman. Esta jerarquía se vuelve más evidente con el uso de la sintaxis de etiquetas de XML.

### 2. Contenido :blue_book:

---

<img src="images/button.png" align="right" height="90"> 

#### <ins>Botones y textos</ins>

Ya entendimos cómo funcionan las vistas, ahora vamos a ensuciarnos las manos y generar una. Utilizaremos algunos de los elementos fundamentales de todas las aplicaciones móviles: **botones** y **texto**.

Los botones son elementos que nos permitirán tener interacciones con los usuarios de nuestras aplicaciones, esperando que ellos hagan click sobre ellos. Al hacer click a uno de nuestros botones, el usuario seguramente esperará una reacción por parte de la aplicación (nadie quiere un botón que no sirve para nada). En este ejemplo la acción del botón será cambiar el texto que muestra la pantalla.

- [**`EJEMPLO 1`**](Ejemplo-01/Readme.md)
- [**`RETO 1`**](Reto-01/Readme.md)

---

<img src="images/text_input.png" align="right" height="90"> 

#### <ins>Inputs e imágenes</ins>

Otros elementos que son muy importantes son las imágenes, para las cuales ampliaremos el dominio a ImageViews y así poder visualizarlas, y también los **inputs**, que son otro medio de interacción con los usuarios, pues nos permiten recibir valores por parte de ellos. Con estos se usa EditTexts para ingresar un texto desde el teclado del móvil y explorar los eventos que este detona. 

- [**`EJEMPLO 2`**](Ejemplo-02/Readme.md)
- [**`RETO 2`**](Reto-02/Readme.md)

---

<img src="images/url_image.png" align="right" height="90"> 

#### <ins>Imágenes mediante URL</ins>

Se mostrarán imágenes en un ImageView por medio de URLS mediante la biblioteca Coil, disponible en _mavenCentral()_. 

- [**`EJEMPLO 3`**](Ejemplo-03/Readme.md)

---


### 3. Proyecto :hammer:

Con los temas anteriores se deberá construir una pantalla de login para la aplicación definida.

- [**`PROYECTO SESIÓN 2`**](Proyecto/Readme.md)

### 4. Postwork :memo:

Con lo aprendido en esta sesión, implementa Views adicionales a tu primera pantalla.

- [**`POSTWORK SESIÓN 2`**](Postwork/Readme.md)

<br/>

[`Anterior`](../Sesion-01/Readme.md) | [`Siguiente`](../Sesion-03/Readme.md)      

</div>

