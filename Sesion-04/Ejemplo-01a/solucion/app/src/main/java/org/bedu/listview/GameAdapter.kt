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