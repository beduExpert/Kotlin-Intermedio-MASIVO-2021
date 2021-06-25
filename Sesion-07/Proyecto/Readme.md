[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 07`](../Readme.md) > `Proyecto`

## Proyecto: Menús y RecyclerView

> <div style="text-align: justify;">

### 1. Objetivos :dart:

- Implementar el uso de Menús Contextuales y Menús Flotantes.

### 2. Requisitos :clipboard:

1. Android Studio Instalado en nuestra computadora.


### 3. Desarrollo :computer:

En este reto final implementaremos una vista de RecyclerView utilizando CardViews que permitan la edición de elementos al seleccionar una celda.

- Las acciones sugeridas a ejecutar son:

	- Duplicar
	- Eliminar
	- Editar

![](./images/1.png)

Al seleccionar una opción de menú debe verse actualizado el `RecyclerView`.
Si se implementa la opción de Editar, esta debe mostrar una nueva vista para editar la información.

### Flujo

El flujo del proyecto comienza con la **Vista-A**, un recycler view. al seleccionar una fila o celda debe ir a vista de detalle **Vista-B**, en donde el título de la celda debe tener uno o varios campos de texto para poder editar su informacion. Con un botón salvaremos la información y regresaremos a la **Vista-A**.

Flujo:

```
**Vista-A** -----[ editar ]--->| **Vista-B**
**Vista-B** |<---[guardar y actualizar]--- **Vista-A**
```

En las opciones de cada campo de texto, se debe implementar un menú contextual con opciones propias. Estas opciones deben ser diferentes a Copiar, Pegar, Cortar texto. Se sugiere algo como verificar correo electronico, poner texto en mayúsculas, compartir en alguna red social.

![](./images/2.png)


![](./images/3.gif)


### Lineamientos

1. Se deben implementar al menos dos vistas en el proyecto.
2. Cualquier forma de implementación de _recyclerview_ es válida.
3. Se deben usar almenos dos tipos de menús contextuales con opciones propias en el proyecto.
4. Uno de los menús debe ser creado por XML y otro sin XML.





[`Anterior`](../Reto-03/Readme.md) | [`Siguiente`](../Postwork/Readme.md)

</div>
