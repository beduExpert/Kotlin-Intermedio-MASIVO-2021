 [`Kotlin Intermedio`](../../Readme.md) > [`Sesión 04`](../Readme.md) > `Ejemplo 1-A`

## Ejemplo 1-A: ListView con Custom Adapter

<div style="text-align: justify;">


### 1. Objetivos :dart:

- Que el alumno aprenda a customizar sus listas para su posterior implementación

### 2. Requisitos :clipboard:

1. Android Studio Instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

- La lista generada previamente servirá como base para este reto, el layout activity_main.xml no se modifica.
- Se debe generar una lista que contenga algunos ganadores de los Game Awards 2019.
- Los datos de lectura son: título, categoría, ESRB, rating y idPortrait (id de imagen)

Las imágenes dentro de cada Item de la lista están en la siguiente [Ruta](resources) (se deben de pasar al directorio *drawable*).


1.- Crear un nuevo Layout para cada Item de nuestra lista, proponemos esta, pero cualquiera que se ajuste al modelo de datos es bien recibido:

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".GameAdapter"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <androidx.constraintlayout.widget.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/guideline"
        app:layout_constraintGuide_begin="44dp"
        android:orientation="horizontal" />

    <androidx.constraintlayout.widget.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/guideline2"
        app:layout_constraintGuide_begin="84dp"
        android:orientation="horizontal" />

    <androidx.constraintlayout.widget.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/guideline3"
        app:layout_constraintGuide_begin="118dp"
        android:orientation="horizontal" />

    <androidx.constraintlayout.widget.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/guideline4"
        app:layout_constraintGuide_begin="172dp"
        android:orientation="horizontal" />

    <androidx.constraintlayout.widget.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/guideline5"
        app:layout_constraintGuide_begin="193dp"
        android:orientation="horizontal" />

    <androidx.constraintlayout.widget.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/guideline6"
        app:layout_constraintGuide_begin="16dp"
        android:orientation="horizontal" />

    <androidx.constraintlayout.widget.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/guideline7"
        app:layout_constraintGuide_begin="122dp"
        android:orientation="vertical" />

    <TextView
        android:id="@+id/tvTitulo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:text="TextView"
        android:textSize="18sp"
        app:layout_constraintBottom_toTopOf="@+id/guideline2"
        app:layout_constraintLeft_toLeftOf="@+id/guideline7"
        app:layout_constraintTop_toTopOf="@+id/guideline" />

    <TextView
        android:id="@+id/tvCategoria"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:text="TextView"
        android:textSize="16sp"
        app:layout_constraintBottom_toTopOf="@+id/guideline3"
        app:layout_constraintLeft_toLeftOf="@+id/guideline7"
        app:layout_constraintTop_toTopOf="@+id/guideline2" />

    <TextView
        android:id="@+id/tvClasificacion"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:layout_marginRight="8dp"
        android:text="TextView"
        app:layout_constraintBottom_toTopOf="@+id/guideline4"
        app:layout_constraintRight_toRightOf="parent" />

    <RatingBar
        android:id="@+id/rbCalificacion"
        style="@style/Widget.AppCompat.RatingBar.Indicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        app:layout_constraintBottom_toTopOf="@+id/guideline4"
        app:layout_constraintLeft_toLeftOf="@+id/guideline7"
        app:layout_constraintTop_toTopOf="@+id/guideline3" />

    <ImageView
        android:id="@+id/imgPortada"
        android:layout_width="105dp"
        android:layout_height="138dp"
        android:layout_marginBottom="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginTop="8dp"
        app:layout_constraintBottom_toTopOf="@+id/guideline5"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toLeftOf="@+id/guideline7"
        app:layout_constraintTop_toTopOf="@+id/guideline6"
        app:srcCompat="@drawable/smash" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

2.- Crear un modelo que consta de una Clase con únicamente constructor y los atributos titulo(String), categoria(String), ESRB(String), rating (Float), idPortrait(Int).

3.- En el [Ejemplo 1](../Ejemplo-01) usábamos un ArrayAdapter con un layout predefinido y con datos simples (un arreglo de Strings)

> val itemsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, modeloCoches)
	
Para este caso, vamos a crear nuestro propio Adaptador, donde el layout sea el anteriormente descrito, y los datos sean un arreglo que contenga instancias de nuestro modelo con la información de los videojuegos ganadores. 

```kotlin
package org.bedu.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class GameAdapter(private val context: Context,
                  private val datos: ArrayList<GameModel>
                    ): BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    //Infla una vista para un Item de la lista, aquí se describe cómo se va a desplegar la info
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //inflamos la vista item_game para cada elemento de la lista
        val rowView = inflater.inflate(R.layout.item_game, parent, false)

        //obtenemos las referencias de cada View de nuestro layout de item_game
        val tvTitulo = rowView.findViewById<View>(R.id.tvTitulo) as TextView
        val tvCategoria = rowView.findViewById<View>(R.id.tvCategoria) as TextView
        val tvClasificacion = rowView.findViewById<View>(R.id.tvClasificacion) as TextView
        val rbCalificacion = rowView.findViewById<View>(R.id.rbCalificacion) as RatingBar
        val imgPortada = rowView.findViewById<View>(R.id.imgPortada) as ImageView

        //obtenemos la información del item por medio de getItem()
        val game = getItem(position) as GameModel

        //seteamos todos los valores a nuestras vistas para desplegar la información
        tvTitulo.text = game.title
        tvCategoria.text = game.category
        tvClasificacion.text = game.ESRB
        rbCalificacion.rating = game.rating
        imgPortada.setImageResource(game.idPortrait)

        return rowView
    }
    

    //regresa un item para ser colocado en la posición position del Listview
    override fun getItem(position: Int): Any {
        return datos[position]
    }

    //Este método define un id para cada item, decidimos usar el index en el array de data
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //este método le dice al ListView cuantos items mostrar
    override fun getCount(): Int {
       return datos.size
    }
}
```
- getView() Se encarga de inflar la vista y de permitir que aquí se muestren los datos
- getItem(position) se encarga de extraer los datos de un Item en específico y los trata (lo utilizamos nosotros en getView)
- getItemId(position) identifica a cada item con un identificador único (nosotros decidimos que fuera su index)
- getCount() sirve al Adaptador para notificarle la cantidad de Items a desplegar

4.- A continuación proporcionamos un método a manera de recuperación de datos, en este caso de los videojuegos ganadores: 
```kotlin
    private fun getGames(): ArrayList<GameModel>{
        val gameModels = arrayListOf(
            GameModel("Call of duty","Audio design", "Mature",3.5f,R.drawable.call_of_duty),
            GameModel("Control","Art direction", "Everyone",4.5f,R.drawable.control),
            GameModel("Destiny 2","Community support", "Everyone",3.7f,R.drawable.destiny2),
            GameModel("Devil may cry 5","Action game", "Teen",4.2f,R.drawable.devil_may_cry_5),
            GameModel("Sekiro: shadows dies twice","Game of the year","Only Adults",3.0f,R.drawable.sekiro),
            GameModel("Super smash bros ultimate","Fighting game", "Everyone",4.9f,R.drawable.smash)
        )

        return gameModels
    }
```

Colóquenlo dentro de la MainActivity.

5.- Con todo lo anterior, crear el GameAdapter y asignarlo al ListView.

6.- Al dar click a cada elemento del ListView, se debe mostrar un Toast que nos indique el nombre del ganador y la categoría ganada.

7.- Debemos obtener algo similar a esto:

<img src="result.png" width="33%">




[`Anterior`](../Ejemplo-01/Readme.md) | [`Siguiente`](../Ejemplo-02/Readme.md)




</div>



