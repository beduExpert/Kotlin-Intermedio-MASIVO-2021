[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 04`](../Readme.md) > `Ejemplo 3`

## Ejemplo 3: RecyclerView

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Comprender el concepto y funcionamiento de un RecyclerView
- Ventajas y desventajas
- Cuál es el núcleo de la diferencia con una ListView

### 2. Requisitos :clipboard:

1. Android Studio Instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

En este proyecto, crearemos una lista de contactos de teléfono sencilla con un RecyclerView.

1.- Abrir un proyecto con una Actividad Básica (Basic Activity), para dejar preparado el terreno del [Reto 02](../Reto-02)

2.- A diferencia de las Actividades vacías, en este caso lo que modificaremos será el archivo ***content_main.xml***, y se ingresará un simple RecyclerView ocupando todo el layout:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context=".MainActivity"
    tools:showIn="@layout/activity_main">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerContacts"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

3.- Crear el layout para cada contacto de teléfono en la lista. Usaremos una imagen de perfil gris:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:paddingVertical="16dp">

    <ImageView
        android:id="@+id/userImage"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:src="@drawable/unknown"
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
        android:id="@+id/tvNombre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:text="Nombre bato"
        android:textSize="16sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/guideline"
        app:layout_constraintStart_toStartOf="@+id/guideline4" />

    <TextView
        android:id="@+id/tvStatus"
        android:layout_width="wrap_content"
        android:layout_height="19dp"
        android:layout_marginTop="8dp"
        android:text="Ya fue"
        app:layout_constraintStart_toStartOf="@+id/guideline4"
        app:layout_constraintTop_toTopOf="@+id/guideline" />

    <TextView
        android:id="@+id/tvPhone"
        android:layout_width="wrap_content"
        android:layout_height="19dp"
        android:text="Ya fue"
        app:layout_constraintEnd_toStartOf="@+id/guideline3"
        app:layout_constraintTop_toTopOf="@+id/tvNombre" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

4.- Tendremos qué crear un Modelo de datos para nuestro arreglo, Por el momento desplegamos nombre, estado, teléfono y foto (es la misma siempre), por lo que nuestro Modelo queda así: 

```kotlin
package org.bedu.recyclercontacts

data class Contact (
    var name: String,
    var status: String,
    var phone: String,
    var idImage: Int
)
```

5.- Con esto, vamos a crear el adaptador de nuestro RecyclerView; aquí veremos la diferencia de estructura con un ListView.

```kotlin
package org.bedu.recyclercontacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//Declaración con constructor
class RecyclerAdapter(
    var context:Context,
    var contacts: MutableList<Contact>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //Aquí atamos el ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contacts.get(position)
        holder.bind(item, context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_contact, parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    //El ViewHolder ata los datos del RecyclerView a la Vista para desplegar la información
    //También se encarga de gestionar los eventos de la View, como los clickListeners
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //obteniendo las referencias a las Views
        val nombre = view.findViewById(R.id.tvNombre) as TextView
        val status = view.findViewById(R.id.tvStatus) as TextView
        val phone = view.findViewById(R.id.tvPhone) as TextView
        val image = view.findViewById(R.id.userImage) as ImageView

        //"atando" los datos a las Views
        fun bind(contact: Contact, context: Context){
            nombre.text = contact.name
            status.text = contact.status
            phone.text = contact.phone
            image.setImageResource(contact.idImage)

            //Gestionando los eventos e interacciones con la vista
            itemView.setOnClickListener{
                Toast.makeText(context, "Llamando a ${contact.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
```

- La primera diferencia que observamos, es que nuestro RecyclerAdapter no ereda de un basicAdapter() como las listas de los otros dos ejemplos; sino de un RecyclerView.Adapter
- Tiene una clase nueva llamada ViewHolder, que asigna los valores de los datos a las vistas correspondientes en el Item, sin crear diversas instancias de esta (reciclando así este recurso).
- sobreescribe el callback onCreateViewHolder, que infla y devuelve la vista. Como no la personaliza, se podrían asignar diferentes vistas para diversos Items.
- contiene onBindViewHolder, que personaliza el tipo de ViewHolder según su posición.

5.- En el *MainActivity*, seteamos el adaptador como un lateinit para poder recuperar su valor en cualquier momento.

```kotlin
private lateinit var mAdapter : RecyclerAdapter
```

6.- Para generar datos dummy, declaramos una función con un arreglo de Contacts predeterminados.
```kotlin
//generamos datos dummy con este método
    private fun getContacts(): MutableList<Contact>{
        var contacts:MutableList<Contact> = ArrayList()

        contacts.add(Contact("Pablo Perez", "disponible", "5535576823",R.drawable.unknown))
        contacts.add(Contact("Juan Magaña", "on smash", "553552432",R.drawable.unknown))
        contacts.add(Contact("Leticia Pereda", "disponible", "5553454363",R.drawable.unknown))
        contacts.add(Contact("Manuel Lozano", "livin' la vida loca", "9613245432",R.drawable.unknown))
        contacts.add(Contact("Ricardo Belmonte", "disponible", "6332448739",R.drawable.unknown))
        contacts.add(Contact("Rosalina", "lookin' to the stars", "7546492750",R.drawable.unknown))
        contacts.add(Contact("Thalía Fernandez", "no fear", "5587294655",R.drawable.unknown))
        contacts.add(Contact("Sebastián Cárdenas", "no molestar", "4475655578",R.drawable.unknown))

        return contacts
    }
```

7.- Embebemos todo el código para configurar y lanzar nuestro RecyclerView en un método que llamaremos en *onCreate()*:

```kotlin
//configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView(){
        recyclerContacts.setHasFixedSize(true)
        //nuestro layout va a ser de una sola columna
        recyclerContacts.layoutManager = LinearLayoutManager(this)
        //seteando el Adapter
        mAdapter = RecyclerAdapter( this,getContacts())
        //asignando el Adapter al RecyclerView
        recyclerContacts.adapter = mAdapter
    }
```

8.- Finalmente, ejecutamos dicho método en onCreate().

La app debe quedar similar a esto:

<img src="result.png" width="33%">



[`Anterior`](../Reto-01/Readme.md) | [`Siguiente`](../Reto-02/Readme.md)




</div>
