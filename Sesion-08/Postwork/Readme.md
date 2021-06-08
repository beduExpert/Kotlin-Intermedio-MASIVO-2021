[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 08`](../Readme.md) > `Postwork`

## Postwork

<div style="text-align: justify;">
  
  
### 1. Objetivos :dart:

- Orientarse en la implementación de flavors para el proyecto.

### 2. Requisitos :clipboard:

- Android Studio Instalado en nuestra computadora.

### 3. Desarrollo :computer:

#### Flavors

A continuación veremos ciertas ideas que nos ayudarán a aterrizar nuestro proyecto.

Probablemente sea dificultoso implementar una nueva función para dos versiones, por lo cual dejamos algunos tips de implementación:

- Para una aplicación que brinde una funcionalidad (como un administrador de gastos), podemos poner una versión que muestre publicidad y otra que no, eso lo podemos hacer mediante un ImageView y un set de imágenes que se muestren de forma aleatoria; esto se puede lograr asignando la imagen de forma dinámica (en el código fuente), la aleatoriedad se puede conseguir metiendo todas las imágenes de publicidad en un arreglo y obteniéndolas con su index, consiguiendo un número aleatorio:

```kotlin
val imageIndex = (0..10).random()
```

- Para cualquier aplicación, podemos restringir algún servicio a ciertos países, por lo cual la dimensión puede ser country. Dicho servicio puede estar alojado en el drawer, por lo que declararíamos dos diferentes xml con su contenido. Dicho servicio podría hacer navegar a un nuevo Activity.

- Otra dimensión podría ser un Theme y algunos elementos gráficos que cambien en tu aplicación. OJO, para que esto cuente, los cambios deben ser significantes.


[`Anterior`](../Proyecto/Readme.md) | [`Siguiente`](../Readme.md)

</div>
