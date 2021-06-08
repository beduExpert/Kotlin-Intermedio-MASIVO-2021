package org.bedu.spinners

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CountryAdapter(private val context: Context,
                     private val datos: ArrayList<CountryModel>
                        ): BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.item_country, parent, false)

        //obtenemos los datos requeridos para desplegar en el layout
        val tvName = rowView.findViewById<View>(R.id.tvName) as TextView
        val ivFlag = rowView.findViewById<View>(R.id.ivFlag) as ImageView

        //obtenemos la información del item por medio de getItem()
        val country = getItem(position) as CountryModel

        //seteamos todos los valores a nuestras vistas para desplegar la información
        tvName.text = country.name
        ivFlag.setImageResource(country.imageId)

        return rowView
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return datos.size
    }


}