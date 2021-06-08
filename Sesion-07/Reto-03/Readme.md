[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 06`](../Readme.md) > `Reto 3`
 
	
## Reto 3: Creando Callback en clase independiente

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Con base al ejemplo-03, implementar una clase dedicada para mostrar el mismo menú flotante.

### 2. Requisitos :clipboard:

1. Haber terminado Ejemplo-03
2. Utilizar clase de ayuda proporcionada en el repositorio.

### 3. Desarrollo :computer:

Crear una clase que implemente un ActionMode.Callback().

```
class PrimaryActionModeCallback : ActionMode.Callback {
}
```

Este callback tendra un OnClick listener, lo implementaremos como Global.


> var onActionItemClickListener: OnActionItemClickListener? = null

Dentro de la clase sobreescribiremos los metodos necesarios, estos son:

	- onCreateActionMode
	- onPrepareActionMode
	- onDestroyActionMode
	- onActionItemClicked

Finalmente creamos un método para configuracion, agregamos titulo, subtitulo y menu.


```
fun startActionMode(view: View,
                        @MenuRes menuResId: Int,
                        title: String? = null,
                        subtitle: String? = null) {
        this.menuResId = menuResId
        this.title = title
        this.subtitle = subtitle
        view.startActionMode(this)
    }
```


Para hacer uso de esta clase:

```
// Start primary ActionMode

val primaryActionModeCallback = PrimaryActionModeCallback()
primaryActionModeCallback.startActionMode(view, R.menu.menu_actions, "Title", "Subtitle")
```

[`Anterior`](../Ejemplo-03/Readme.md) | [`Siguiente`](../Proyecto/Readme.md)



</div>
