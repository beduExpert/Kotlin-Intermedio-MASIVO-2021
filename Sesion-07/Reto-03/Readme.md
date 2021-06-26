[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 06`](../Readme.md) > `Reto 3`
 
	
## Reto 3: Creando Callback en clase independiente

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Implementar una clase dedicada para mostrar un menú flotante usado en el proyecto del ejemplo 03.

### 2. Requisitos :clipboard:

1. Conclusión de actividades del Ejemplo-03.
2. Utilizar clase de ayuda proporcionada en el repositorio.

### 3. Desarrollo :computer:

Crear una clase que implemente un `ActionMode.Callback()`.

```
class PrimaryActionModeCallback : ActionMode.Callback {
}
```

Este _callback_ tendrá un `OnClick listener`; lo implementaremos como Global.


    var onActionItemClickListener: OnActionItemClickListener? = null

Dentro de la clase sobreescribiremos los métodos necesarios, estos son:

- `onCreateActionMode`
- `onPrepareActionMode`
- `onDestroyActionMode`
- `onActionItemClicked`

Finalmente creamos un método para configuracion, agregamos título, subtítulo y menú.


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
