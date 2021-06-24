[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 05`](../Readme.md) > `Ejemplo 2`

## Ejemplo 2: Fragments Lista-Detalle (UI)

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Adaptar un diseño de acuerdo al tamaño de una pantalla.

### 2. Requisitos :clipboard:

1. Android Studio Instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

En este ejemplo abordaremos una aplicación que sigue el patrón `lista-detalle`, en el cual tendremos una lista de productos y al seleccionar uno, visualizaremos sus detalles. En este ejercicio ejemplificamos el uso de `Fragments` para un diseño de interfaz flexible, ya que para un teléfono móvil convencional, la lista se mostrará en una pantalla y el detalle en otra. En el caso de una tablet, que consta de una pantalla grande, pondremos la vista y el detalle en la misma pantalla. El siguiente diagrama nos ayudará a visualizar la idea.

<img src="images/1.png" width="70%">

La diferencia es que las dos pantallas irán en orden vertical para el caso de la tablet.


1. Abre __Android Studio__ y crea un nuevo proyecto con Activity Vacía (Empty Activity).

2. Copiaremos las imágenes que se encuentran en [Esta carpeta](ListDetailFragment/app/src/main/res/drawable-v24) y las pegamos en nuestro directorio de recursos `drawable` para poder utilizarlos en nuestros productos.

3. En el directorio `layout`, diseñaremos el template de un elemento de nuestra lista de productos y lo llamaremos `item_contact.xml`, y tendrá el siguiente código:

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:paddingVertical="16dp">

    <ImageView
        android:id="@+id/imgProduct"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:src="@drawable/kobo"
        app:layout_constraintBottom_toTopOf="@+id/guideline"
        app:layout_constraintStart_toStartOf="@+id/guideline2"
        app:layout_constraintTop_toTopOf="@+id/guideline" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent=".5" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.08" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.9" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent="0.26" />

    <TextView
        android:id="@+id/tvProduct"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:text="Producto"
        android:textSize="16sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/guideline"
        app:layout_constraintStart_toStartOf="@+id/guideline4" />

    <TextView
        android:id="@+id/tvDescription"
        android:layout_width="wrap_content"
        android:layout_height="19dp"
        android:layout_marginTop="8dp"
        android:text="Descripción"
        app:layout_constraintStart_toStartOf="@+id/guideline4"
        app:layout_constraintTop_toTopOf="@+id/guideline" />

    <TextView
        android:id="@+id/tvPrice"
        android:layout_width="wrap_content"
        android:layout_height="19dp"
        android:textStyle="bold"
        android:textColor="#000"
        android:text="$1,000"
        app:layout_constraintEnd_toStartOf="@+id/guideline3"
        app:layout_constraintTop_toTopOf="@+id/tvProduct" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

Los textos introducidos por default se reemplazarán por los del producto. El `layout` debe quedar de la siguiente forma:

<img src="images/2.png" width="70%">

4. De forma similar, vamos a crear un layout `fragment_detail.xml` donde irá el detalle de nuestro producto seleccionado.

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/detailView"
    android:visibility="visible"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingVertical="16dp">

    <TextView
        android:id="@+id/tvProduct"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Producto"
        android:textSize="32sp"
        android:textStyle="bold"
        android:layout_marginTop="16dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="@+id/guideline4" />
    <TextView
        android:id="@+id/tvDescription"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Descripción"
        android:textSize="18sp"
        app:layout_constraintTop_toBottomOf="@id/tvProduct"
        app:layout_constraintStart_toStartOf="@+id/guideline4" />
    <RatingBar
        android:id="@+id/rbRate"
        style="@style/Widget.AppCompat.RatingBar.Indicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/tvDescription"
        app:layout_constraintStart_toStartOf="@+id/guideline4"
        />
    <ImageView
        android:id="@+id/imgProduct"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:src="@drawable/kobo"
        app:layout_constraintTop_toBottomOf="@id/rbRate"
        app:layout_constraintStart_toStartOf="@id/guideline5"
        app:layout_constraintEnd_toEndOf="@id/guideline6"/>

    <TextView
        android:id="@+id/tvPrice"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textStyle="bold"
        android:textColor="#000"
        android:textSize="24sp"
        android:text="$1,000"
        app:layout_constraintTop_toBottomOf="@id/imgProduct"
        app:layout_constraintStart_toStartOf="@id/guideline4"/>

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent=".05" />
    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent=".3" />
    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_percent=".6" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

El layout debe verse de esta forma:

<img src="images/3.png" width="40%">

Ahora vamos a ocultar el layout, mas adelante veremos por qué lo haremos, modificaremos la propiedad de visibilidad del `ConstraintLayout`.

```xml
android:visibility="invisible"
```

5. Ahora crearemos un nuevo archivo _xml_ llamado `fragment_list` para nuestro `Fragment`. Este layout representará la lista de productos en venta, por lo tanto, utilizaremos un `RecyclerView` Dentro del layout.

```xml
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ListFragment">
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerProducts"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</FrameLayout>
```

6. Perfecto! Ahora modificaremos nuestro `activity`main.xml_ para que muestre únicamente la lista de productos (teléfono móvil), por lo tanto únicamente agregaremos nuestro `fragment` al layout.

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <fragment
        android:id="@+id/fragmentList"
        class="org.bedu.listdetailfragment.ListFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```

7. Debido a que la versión de móvil requiere una pantalla para la lista y otra para el detalle, crearemos un `detail_activity.xml` donde contendremos únicamente a nuestro `fragment`.

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <fragment
        android:id="@+id/fragmentDetail"
        class="org.bedu.listdetailfragment.DetailFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```


8. Al parecer tenemos todo listo... 

Pero, ¿En qué momento creamos la pantalla para la versión tablet? Para este caso, debemos crear un `layout` específico que reemplace al `activity_main` original cuando la pantalla sea grande. Para esto, damos click derecho en `res` y nos vamos a _New > Android Resource Directory_.

<img src="images/4.png" width="70%">

En este menú, seleccionamos las siguientes opciones:

<img src="images/5.png" width="70%">

El *qualifier* nos servirá para saber qué layouts debe elegir la app, en este caso el parámetro será el tamaño de la pantalla, por lo que seleccionaremos `size` y utilizaremos la opción `large`.

<img src="images/6.png" width="30%">

Listo! ahí guardaremos el `layout` de la versión tablet. 

Nos podemos ahorrar estos pasos simplemente creando un directorio con el nombre `layout-large`.

9. Dentro de `layout-large`, creamos otro archivo `activity_main.xml`, que contendrá nuestros fragmentos en vertical.

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
        app:layout_constraintBottom_toTopOf="@id/half"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>
    <fragment
        android:id="@+id/fragmentDetail"
        class="org.bedu.listdetailfragment.DetailFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="@id/half"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/half"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_percent=".5" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
Y con eso quedo listo el apartado gráfico, en el siguiente ejemplo implementaremos el patrón del lado de Kotlin,





[`Anterior`](../Reto-01/Readme.md) | [`Siguiente`](../Reto-02/Readme.md)




</div>
