[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 05`](../Readme.md) > `Ejemplo 3`

## Ejemplo 3: Fragment Transactions

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Crear y remover _Fragments_ programáticamente.
- Mostrar y esconder un _Fragment_ en específico.
- Visualizar cómo las transacciones afectan al ciclo de vida de un _Fragment_.

### 2. Requisitos :clipboard:

1. Android Studio Instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

Hasta ahora hemos declarado ___Fragments___ por medio del tag ___fragment___ dentro del archivo _xml_ del layout de un _Activity_, pero también esto se puede hacer de forma programática utilizando un _contenedor_, tal como un ___ViewGroup___. En este caso, vamos a utilizar operaciones para manipular el ciclo de vida de un ___Fragmnet___ mediante el ___supportFragmentManager___. La lista de acciones que haremos son:

* Agregar un _Fragment_
* Removerlo
* Ocultarlo
* Mostrarlo
* Agregar un segundo _Fragment_
* Remover el segundo _Fragment_
* Attach (adjuntar)
* Detach (remover)
* Reemplazar por un _Fragment_
* Reemplazar por el segundo _Fragment_

1. Abre __Android Studio__ y crea un nuevo proyecto con Activity Vacía (Empty Activity).

2. Crearemos un nuevo _layout_ para nuestro ___activity_main.xml___, de modo que en la parte superior tengamos un arreglo horizontal scrolleable de botones que corresponderán a las acciones a realizar. Bajo esta barra de botones, tendremos el ___FrameLayout___ que fungirá como contenedor para agregar nuestros ___Fragments___. 

```xml 
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <HorizontalScrollView
        android:id="@+id/scroll"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent">
        <LinearLayout
            android:paddingVertical="12dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
            <Button
                android:id="@+id/addButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Agregar" />

            <Button
                android:id="@+id/removeButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Remover" />
            <Button
                android:id="@+id/hideButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Esconder" />
            <Button
                android:id="@+id/showButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Mostrar" />
            <Button
                android:id="@+id/add2Button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Agregar 2" />
            <Button
                android:id="@+id/remove2Button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Remover 2" />
            <Button
                android:id="@+id/attachButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Attach" />
            <Button
                android:id="@+id/detachButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Detach" />
            <Button
                android:id="@+id/replace1Button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Remplazar por 1" />

            <Button
                android:id="@+id/replace2Button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Reemplazar por 2" />
        </LinearLayout>
    </HorizontalScrollView>
    <FrameLayout
        android:background="#DDD"
        android:id="@+id/container"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toBottomOf="@id/scroll"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>
</androidx.constraintlayout.widget.ConstraintLayout>
```

3. Crearemos dos ___Fragments___: El primero llevará el [Logo de Bedu]() y su _layout_ llamará ___fragment_bedu.xml___.

```xml 
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android"
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

Su clase correspondiente será la siguiente:

```kotlin
class BeduFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bedu, container, false)
        
        return view
    }

}
```

Recuerdas el [../Reto-01]? Ahí examinamos el ciclo de vida de un ___Fragment___, así que tomaremos la implementación de ___callbacks___ para analizar el ciclo de vida cuando hagamos una transacción.

4. Para el segundo Fragment, repetimos el paso anterior, cambiando los nombres a ___fragment_beto.xml___ y a ___BetoFragment___ respectivamente. El nombre de la imagen del layout será ___beto.png___. Para los _Logs_, podemos poner un identificador en el texto para distinguirlos.

5. Aunque google no lo recomienda, utilizaremos para esta ocasión _kotlinx synthetic_ En nuestro ___MainActivity___, para saltarnos la asignación de las _Views_. obtenemos el ___supportFragmentManager___ y lo guardamos en una variable.

En el _listener_ del botón de agregar, crearemos una nueva _Transaction_, creamos una instancia de ___BeduFragment___, la agregamos al _container_ con el _tag_ "fragBedu" (que nos servirá para identificarlo) y aplicamos los cambios mediante el método ___commit___.

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    ...
    
    val manager = supportFragmentManager


    //Agregaremos un nuevo Fragment
    addButton.setOnClickListener {
        val fragment = BeduFragment()
        val transaction = manager.beginTransaction()
        transaction.add(R.id.container, fragment, "fragBedu")
        transaction.commit()
    }
}
```
Abajo de esta, creamos el _listener_ para remover un ___Fragment___, el _fragment_ será encontrado por el tag que asignamos anteriormente ("fragBedu").

```kotlin
removeButton.setOnClickListener {
            val fragment = manager.findFragmentByTag("fragBedu") as BeduFragment
            val transaction = manager.beginTransaction()
            transaction.remove(fragment)
            transaction.commit()
        }
```

Corremos el código e inmediatemente pulsamos el botón remover... Qué sucede?

<img src="images/1.png" width="80%">

Como no se encontró ningún fragment con ese tag, el valor nos arroja nulo y al querer hacer un __cast__, nos arroja un error. Por lo tanto, verificaremos si se encontró dicho fragment

```kotlin
val fragmentTag = manager.findFragmentByTag("fragBedu")

if(fragmentTag!=null){
    val fragment = fragmentTag as BeduFragment
    val transaction = manager.beginTransaction()
    transaction.remove(fragment)
    transaction.commit()
} else{
    Toast.makeText(this, "No hay ningún FragmentBedu agregado",Toast.LENGTH_SHORT).show()
}
```
            
Corremos nuevamente el código y hacemos los siguientes ejercicios. Discutir los resultados y analizar cómo se comporta el ciclo de vida para cada uno.

- Remover sin que exista un ___Fragment___
- Agregar un fragment y eliminarlo
- Agregar tres fragments y eliminar dos

6. Ahora vamos a mostrar y ocultar un _fragment_, para esto utilzaremos los métodos ___hide___ y ___show___. El código es idéntico al de remover, excepto el nombre del método, en los cuales utilizaremos

```kotlin
transaction.hide(fragment)
```

y

```kotlin
transaction.show(fragment)
```
Corremos nuevamente el código y hacemos los siguientes ejercicios. 

- Esconder/mostrar sin que exista un ___Fragment___
- Agregar un fragment, esconderlo y mostrarlo

7. Ahora implementaremos ___attach___ y ___detach___. Para hacer una diferenciación, el método ___add___ agrega un _fragment_ que puede tener su propi _View_ Al estado del _activity_, mientras que ___attach___, adjunta nuevamente el _fragment_ a la UI. Mientras que ___remove___ elimina el _View_ del _fragment_ y el estado del _FragmentManager_, ___detach___ destruye únicamente el _View_.

La implementación, nuevamente, se realiza de forma similar al _remove_.

```kotlin
transaction.attach(fragment)
```

```kotlin
transaction.detach(fragment)
```


[`Anterior`](../Readme.md) | [`Siguiente`](../Reto-02)

Corremos nuevamente el códido y hacemos los siguientes ejercicios. 

- Attach/detach sin que exista un ___Fragment___
- Agregar un fragment, Attach y Detach


8. Ahora vamos a agregar la opción de agregar/eliminar un segundo _fragment_, es aquí donde ___BetoFragment___ entra en acción.El código es el mismo que para el primer _fragment_, pero adaptado para el segundo _fragment_.

```kotlin
add2Button.setOnClickListener {
            val fragment = BetoFragment()
            val transaction = manager.beginTransaction()
            transaction.add(R.id.container, fragment, "fragBeto")
            transaction.commit()
        }

        remove2Button.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBeto")

            if(fragmentTag!=null){
                val fragment = fragmentTag as BetoFragment
                val transaction = manager.beginTransaction()
                transaction.remove(fragment)
                transaction.commit()
            } else{
                Toast.makeText(this, "No hay ningún FragmentBeto agregado",Toast.LENGTH_SHORT).show()
            }
        }
```

Los ejercicios a hacer son los siguientes:

- Agregar un FragmentBeto y removerlo
- Agregar un FragmentBedu, agregar un FragmentBeto, eliminar el FragmentBeto y luego el FragmentBedu
- Agregar un FragmentBedu, agregar un FragmentBeto, eliminar el FragmentBedu y luego el FragmentBeto (Remarcar la estructura LIFO).

8. Por último, utilizaremos la función ___replace___, que reemplazará todo lo contenido en el contenedor por el fragment que le pasemos. 

```kotlin
replace1Button.setOnClickListener {
    val beduFragment = BeduFragment()
    val transaction = manager.beginTransaction()
    transaction
        .replace(R.id.container,beduFragment,"fragBedu")
        .commit()
}
```

De la misma forma, podemos hacer el ___replace___ para el otro _fragment_.

Los ejercicios son los siguientes:

- Agregar un _FragmentBedu_ y reemplazarlo por un _FragmentBeto_
- Crear varios _FragmentBedu_ y _FragmentBeto_ y reemplazarlos por cualquiera de los fragments.

[`Anterior`](../Reto-02/Readme.md) | [`Siguiente`](../Proyecto/Readme.md)



</div>
