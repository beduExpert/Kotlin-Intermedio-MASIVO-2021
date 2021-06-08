[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 6`](../Readme.md) > `Reto 2`
    
## Reto 2

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Implementar algún atributo de un _Theme_ en un _View_ específico.
- Crear un Theme oscuro.

### 2. Requisitos :clipboard:

1. Android Studio instalado

### 3. Desarrollo :computer:

Tomaremos el ejercicio realizado en el proyecto del [Ejemplo 3](../Ejemplo-03) para nuestros ejercicios.



1. En el ejemplo [Ejemplo 3](../Ejemplo-03), faltó implementar lo siguiente en el _Drawer_:

<image src="../Ejemplo-03/images/7.png" width="35%">
    
Implementar el diseño del código, de forma que quede así:

<image src="images/1.png" width="35%">
    
Y al cambiar al _Theme_ ___AppTheme.RedBlue___ quede así:

<image src="images/2.png" width="35%">


<details><summary>Solución</summary>

```xml
   <LinearLayout
         ...
    android:paddingBottom="16dp"
    android:background="?attr/colorAccent"
         >
    <ImageView
```
</details>

2. Generar un nuevo ___Dark Theme___, para esto, hereda de ___Theme.MaterialComponents.NoActionBar___. (Ejercicio abierto, sujeto a revisión).

<br/>

[`Anterior`](../Ejemplo-03/Readme.md) | [`Siguiente`](../Proyecto/Readme.md)



</div>
