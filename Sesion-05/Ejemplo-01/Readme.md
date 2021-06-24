[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 05`](../Readme.md) > `Ejemplo 1`

## Ejemplo 1: Fragments

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Crear un Fragment dentro de un View.

### 2. Requisitos :clipboard:

1. Android Studio Instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

1. Abre __Android Studio__ y crea un nuevo proyecto con Activity Vacía (Empty Activity).

2. En el directorio _layout_ crearemos un nuevo archivo _xml_ para nuestro `Fragment`. Este layout representa la interfaz de nuestro Fragmento, que en este caso será una simple imagen contenida en un _ImageView_.

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="120dp"
        android:layout_height="120dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:src="@drawable/bedu" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

3. Dentro del _activity_main.xml_, incluiremos un `fragment` que contendrá el `layout` generado previamente.

```xml 
<fragment
        xmlns:android="http://schemas.android.com/apk/res/android"
        class="com.example.fragments.ExampleFragment"
        android:id="@+id/frgDetalle"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

4. ¡Muy bien! Ahora toca asociar el view nuestro `Fragment` a su respectiva clase, por lo tanto creamos un nuevo archivo .kt y creamos nuestra clase que extenderá de la Superclase __Fragment__ .

```kotlin
class ExampleFragment : Fragment() {
 
}
```

Para asociar nuestro layout a la clase, utilizamos el método `inflate` dentro de la función `onCreateView` y en el primer argumento pasamos el ID de nuestro layout con `R.layout.fragment_layout`.

La función `onCreateView()` se llama  cuando el fragmento debe diseñar su interfaz de usuario por primera vez. A fin de diseñar una IU para tu fragmento, debes mostrar un `View` desde este método, que será la raíz del diseño de tu fragmento. Puedes mostrar un valor nulo si el fragmento no proporciona una IU.

```kotlin
 override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }
```

El resultado es la siguiente pantalla!

<img src="images/1.png" width="50%">
      
      
Una forma Automática de crear una clase `Fragment` junto a su `layout` es yendo a nuestro directorio principal y creando ahí un `Blank Fragment`. Este creará automáticamente nuestra clase con varios callbacks implementados, su `layout` en el respectivo directorio, y el método `onCreateView` con el id del layout como parámetro.

<img src="images/2.png" width="50%">

El `layout` se creará con la siguiente estructura:

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".BlankFragment">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="@string/hello_blank_fragment" />

</FrameLayout>
```

Podemos reemplazar los elementos para que concuerden con lo requerido (en este caso, basta reemplazar el `TextView` por un `ImageView`).

[`Anterior`](../Readme.md) | [`Siguiente`](../Reto-01/Readme.md)




</div>
