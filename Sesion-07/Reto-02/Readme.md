
[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 07`](../Readme.md) > `Reto 2`


## Reto 2: Agregando funcionalidad a los Menús

<div style="text-align: justify;">

### 1. Objetivos :dart:

- Agregar mas elementos a los menus de opciones

### 2. Requisitos :clipboard:

1. Android Studio 4.1
2. Kotlin 1.3
3. AVD Virtual device con API 11 (Android 3.0) o superior
4. Conexión a internet

### 3. Desarrollo :computer:

El reto consiste en agregar funcionalidad a cada opción elegida en el menú.

Nos apoyaremos del siguiente código.

```
 if (item.isChecked) {
                    Toast.makeText(this, "Item1 Checked", Toast.LENGTH_LONG).show()
                    item.setChecked(false)
                } else {
                    Toast.makeText(this, "Item1 Not Checked", Toast.LENGTH_LONG).show()
                    item.setChecked(true)
                }
```

Se debe identificar en que parte del proyecto debe agregarse este código.
Igualmente jugar con el método `item.setChecked(false)`.

![Elemento de Menu](./images/1.gif)


[`Anterior`](../Ejemplo-02/Readme.md) | [`Siguiente`](../Ejemplo-03/Readme.md)




</div>

