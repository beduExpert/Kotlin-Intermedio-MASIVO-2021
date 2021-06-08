[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 05`](../Readme.md) > `Reto 2`
	
## Reto 2 

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Analizar el ciclo de vida de un _Fragment_ y su comportamiento al realizar diversas acciones.

### 2. Requisitos :clipboard:

1. Android Studio instalado
2. Emulador de android tablet configurado.

### 3. Desarrollo :computer:

El ejerecicio anterior tiene un layout similar a este:

 <img src="../Ejemplo-02/images/9.png" width="33%">

Sin embargo, queremos que para el caso de una tablet, tengamos una Interfaz más parecida a la del diagrama:

 <img src="../Ejemplo-02/images/1.png" width="70%">
 
 El ejercicio consistirá en adaptar el layout para tenerlo de la forma vertical para la versión ___portrait___, como para la ___landscape___.

1. Utilizando el ejemplo anterior, modificar únicamente el layout para dispositivos grandes (la lista debe abarcar el 40% de la pantalla).

2. Crear una versión landscape para cuando la tablet esté en posición horizontal (la lista debe abarcar el 35% de la pantalla).

Para que nuestro diseño reacciones a la orientación del teléfono, abriremos nuestro ___AndroidManifest.xml___ e ingresamos en nuestro tag aludiendo a ___MainActivity___.

```xml
android:screenOrientation="sensor"
```

<details><summary>Solución</summary>

Para tener una versión landscape, crearemos un ___android resource directory___ con los _qualifiers_ ___Size___ con valor ___large___ y ___orientation___ con valor ___landscape___.
	
el código quedaría de esta forma:

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <fragment
        android:id="@+id/fragmentList"
        class="org.bedu.listdetailfragment.ListFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="@id/guideline"/>
    <fragment
        android:id="@+id/fragmentDetail"
        class="org.bedu.listdetailfragment.DetailFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="@id/guideline"
        app:layout_constraintEnd_toEndOf="parent"/>

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.4" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

Para la versión _portrait_, bastaría únicamente modificar reutilizar el código anterior para ___fragment_detail___ de nuestro directorio ___layout-large___ y que tenga el 0.5 de porcentaje.

</details>
<br/>

[`Anterior`](../Ejemplo-02/Readme.md) | [`Siguiente`](../Ejemplo-03/Readme.md)




</div>
