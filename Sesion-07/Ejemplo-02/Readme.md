
[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 07`](../Readme.md) > `Ejemplo 2`


## Ejemplo 2: Menús y Eventos

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Implementar acciones en la selección de opciones de determinados tipos de menú creados previamente.

### 2. Requisitos :clipboard:

1. Android Studio 4.1
2. Kotlin 1.3
3. AVD Virtual device con API 11 (Android 3.0) o superior
4. Conexión a internet
5. Códigos de la Sesion-01 completos

### 3. Desarrollo :computer:

Esta vez aprenderemos cómo agregar acciones a los ítems de nuestros menús. Para ello dividiremos nuevamente el ejemplo en 3 secciones, una por cada tipo de menú.
	
Sigue los pasos para cumplir con los objetivos.

### OPTIONS MENU

Retomaremos el Ejemplo de [options_menu](./options_menu) para agregarle funcionalidad a las opciones de menú.

![MainActivity](./images/4.png)


Para ello, nos dirigimos al `MainActivity`, y escribimos la función encargada de obtener la opción elegida en el menú.

```
override fun onOptionsItemSelected(item: MenuItem): Boolean {
	return super.onOptionsItemSelected(item)
}
```

Luego, comparamos cada `id` dentro del Menú.

```
override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.item1 -> {
                return true
            }
            // implementar resto de opciones
        }
        return super.onOptionsItemSelected(item)
    }
```

Finalmente, para el resto de opciones:

```
 override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "Item1", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.item2 -> {
                Toast.makeText(this, "Item2", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.item3 -> {
                Toast.makeText(this, "Item3", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
```

---

### CONTEXTUAL MENU

Retomaremos el Ejemplo de [context_menu](./context_menu) para agregarle funcionalidad a las opciones de menú.

![MainActivity](./images/7.gif)

Para ejecutar acciones de acuerdo al elemento seleccionado del menú, nos basaremos en la función `onContextItemSelected(item: MenuItem?)`.

```
 override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.copy -> {
                Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }
```

De esta misma forma se pueden implementar el resto de las acciones para los elementos del menú.

---

### POPUP MENU

Usaremos el Ejemplo de [popup_menu](./popup_menu) para agregarle funcionalidad a las opciones de menú.

Este código difiere debido a que implementaremos un **closure** para el `PopUpMenu`, y dentro de este **closure** obtendremos la opción deseada mediante un capture _list_.

```
override fun onClick(v: View?) {
        var popMenu = PopupMenu(this, v)
        popMenu.menuInflater.inflate(R.menu.popmenu, popMenu.menu)
        // implementar closure
        popMenu.show()
    }
```

Captamos cada opción de menú con su `id` correspondiente.

```
override fun onClick(v: View?) {
    var popMenu = PopupMenu(this, v)
        popMenu.menuInflater.inflate(R.menu.popmenu, popMenu.menu)
        popMenu.setOnMenuItemClickListener { item ->
            when(item.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "option 1", Toast.LENGTH_SHORT).show()
                    true
                }
            }
            false
        }
    popMenu.show()
}
```


#### Referencias: 

Puedes consultar la documentación oficial para ver más ejemplos y más herramientas que se pueden utilizar con los menús.

> https://developer.android.com/guide/topics/ui/menus?hl=es#xml

[`Anterior`](../Reto-01/Readme.md) | [`Siguiente`](../Reto-02/Readme.md)




</div>

