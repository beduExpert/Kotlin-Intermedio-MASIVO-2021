package org.bedu.recyclercontacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//Declaración con constructor
class RecyclerAdapter(
    var context:Context,
    var contacts: MutableList<Contact>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //Aquí atamos el ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contacts.get(position)
        holder.bind(item, context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_contact, parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    //El ViewHolder ata los datos del RecyclerView a la Vista para desplegar la información
    //También se encarga de gestionar los eventos de la View, como los clickListeners
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //obteniendo las referencias a las Views
        val nombre = view.findViewById(R.id.tvNombre) as TextView
        val status = view.findViewById(R.id.tvStatus) as TextView
        val phone = view.findViewById(R.id.tvPhone) as TextView
        val image = view.findViewById(R.id.userImage) as ImageView

        //"atando" los datos a las Views
        fun bind(contact: Contact, context: Context){
            nombre.text = contact.name
            status.text = contact.status
            phone.text = contact.phone
            image.setImageResource(contact.idImage)

            //Gestionando los eventos e interacciones con la vista
            itemView.setOnClickListener{
                Toast.makeText(context, "Llamando a ${contact.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }


}