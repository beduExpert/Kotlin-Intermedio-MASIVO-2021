[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 03`](../Readme.md) > `Ejemplo 2`

<div style="text-align: justify;">

## Ejemplo 2: Constraint Layout

### 1. Objetivos :dart: 

- Ordenar Componentes por medio de anclajes en un Constraint layout.

### 2. Requisitos :clipboard:

1. Android Studio instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

El objetivo de este ejemplo es apilar las Views como la siguiente imagen.


<img src="images/00.png" width="35%">


Para ello deben realizarse los siguientes pasos:
 
1.- Abrir un nuevo proyecto con Activity vacía.

2.- El trabajo será únicamente con Layouts, así que es necesario ir directamente a activity_main.xml.

3.- Los proyectos empiezan con Constraint Layout por defecto, así que sólo requerimos meter las vistas que teníamos en el reto anterior, por lo cual sólo hay que borrar el Text y reemplazar por la siguiente fracción de XML


```xml
 <View
        android:id="@+id/green"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:background="#00FF00"
        />

    <View
        android:id="@+id/blue"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:background="#0000FF"
       />

    <View
        android:id="@+id/red"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:background="#FF0000"
         />

    <View
        android:id="@+id/pink"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:background="@color/colorAccent"
       />

    <View
        android:id="@+id/yellow"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:background="#FFFF00"
        />

```

El código debe quedar similar a la imagen: 

<img src="images/01.png" width="70%">

No hay que preocuparse por los errores, esto sucede porque dentro de un constraint layout los hijos deben de anclarse a algún lugar.

4.- Selecciona la pestaña **Design**, con ella la interacción de Constraint Layout es mucho más interactiva y eficaz.

<img src="images/02.png" width="70%">

5.- Los Views aparecerán de forma desordenada. Acércate a uno y verás cuatro puntos de anclaje, y si arrastras desde ahí verás salir una flecha. Esos son los puntos de anclaje y los puedes poner sobre otros puntos, sobre líneas de guía, barreras, o sobre los límites del layout. Arrastra el View amarillo al límite inferior del layout.

<img src="images/03.png" width="35%">

6.- Ahora arrastra los puntos de anclaje laterales a los límites laterales del layout para que este quede centrado.

7.- Arrastra el punto de anclaje inferior del View verde al superior del amarillo para unirlos

<img src="images/04.png" width="35%">

8.- Termina de apilar todas las cajas 
 
¡Felicidades!



Puedes estudiar el código generado para comprender un poco cómo funciona el XML generado.


Continúa experimentando con la UI y Constraint Layout para seguir aprendiendo.

[`Anterior`](../Ejemplo-01/Readme.md) | [`Siguiente`](../Ejemplo-03/Readme.md)
</div>
