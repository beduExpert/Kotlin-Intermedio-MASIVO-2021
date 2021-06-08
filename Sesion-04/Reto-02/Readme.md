[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 04`](../Readme.md) > `Reto 2`

## Reto 2: Agregando Items al RecyclerView

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Que el programador aprenda a actualizar el RecyclerView cuando se le agregue un nuevo elemento

### 2. Requisitos :clipboard:

1. Android Studio Instalado en nuestra computadora.
2. Seguir la instrucción específica para esta sesión.

### 3. Desarrollo :computer:

Continuando con el proyecto del ejemplo 3, vamos a crear la interfaz para agregar nuevos usuarios, hay que contemplar que por ahorro de tiempo no pondremos ningún filtro en el nombre, ni en el teléfono de cada contacto agregado.

Utilizaremos el botón redondo llamado FAB (Floating Action Button) para ir a la pantalla de agregar contacto nuevo.

No olvidar utilizar *startActivityForResult* para obtener el resultado del contacto de regreso a la pantalla principal.

```kotlin 
 val intent = Intent(this,AddContactActivity::class.java)
 startActivityForResult(intent,1)
```
<img src="01.png" width="30%">

Hay que implementar en la Actividad detonante la función *onActivityResult*, para recibir la info una vez haya sido envidada. 

```kotlin
 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

               //ToDo: aquí va el código para actualizar el RecyclerView


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
```

y en la clase AddContactActivity():

```kotlin
class AddContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        buttonAdd.setOnClickListener{
            val name = editName.text.toString()
            val phone = editPhone.text.toString()
            val status = "disponible"
            val imgProfile = R.drawable.unknown

            val contact = Contact(name,status,phone,imgProfile)

            val returnIntent = Intent()
            returnIntent.putExtra("new_contact", contact)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }


}
```

El diseño de esa página lo dejararemos a criterio propio.



[`Anterior`](../Ejemplo-03/Readme.md) | [`Siguiente`](../Proyecto/Readme.md)




</div>

