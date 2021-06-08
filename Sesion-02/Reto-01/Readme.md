[`Kotlin Intermedio`](../../Readme.md) > [`Sesión 02`](../Readme.md) > `Reto 1`
	
## Reto 1

<div style="text-align: justify;">

### 1. Objetivos :dart:



### 2. Requisitos :clipboard:

1. Android Studio instalado
2. Al menos un Emulador android configurado

### 3. Desarrollo :computer:

Este diagrama podría ser de ayuda para este reto:

<img src="images/view_diagram.png">


1. Cambiar de color de los siguientes elementos:

- El background del layout en un tono azul claro.
- Las letras del _TextView_ y _Button_ color gris claro (usar el atributo ___textColor___)


<details><summary>Solución</summary>
<p>

agregar los colores al archivo _colors.xml_:

```xml
<color name="background">#03A1C5</color>
<color name="grayClear">#CCC</color>
```

asignar el color al atributo ___background___ de nuestrlo _LinearLayout_:

```xml
android:background="@color/background"
```

agregar tanto a _Button_ como a _TextView_ :

```xml
android:textColor="@color/grayClear"
```

</p>
</details>
<br/>

2. El contenido de un _Button_ es su texto. Aumentar el espacio del botón en 8dp verticalmente y 16dp horizontalmente.  

<details><summary>Solución</summary>
<p>
	
```xml
android:paddingVertical="8dp"
android:paddingHorizontal="16dp"
```

</p>
</details>
<br/>

3. Cuando el usuario pulse el botón, este debe deshabilitarase (atributo ___enabled___ tipo booleano) y el texto debe hacerse invisible (atributo ___visibility___ con valores View.VISIBLE, View.INVISIBLE y View.GONE)

<details><summary>Solución</summary>
<p>
	
En el listener del click en el botón, agregar lo siguiente:
```xml
text.visibility = View.INVISIBLE
btnAccept.isEnabled = false
```
</p>
</details>
<br/>

4. Experimentar con las medidas del botón y el text. Qué sucede al asignarle a width y a height el valor "match_parent"? Experimentar con gravity y layout_gravity.

[`Anterior`](../Ejemplo-01/Readme.md) | [`Siguiente`](../Ejemplo-02/Readme.md)

</div>
