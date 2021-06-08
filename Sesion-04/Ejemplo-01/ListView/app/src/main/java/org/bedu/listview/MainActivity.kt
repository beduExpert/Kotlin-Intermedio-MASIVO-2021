package org.bedu.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.widget.AdapterView.OnItemClickListener


class MainActivity : AppCompatActivity() {

    private val modeloCoches = arrayOf(
        "Vento",
        "Jetta",
        "Fit",
        "Sonic",
        "206",
        "Tsuru",
        "Versa",
        "Windstar",
        "Safira",
        "Monsa",
        "Lobo",
        "HR-V",
        "Gol",
        "Bora",
        "Rav4",
        "Astra",
        "Mustang",
        "Corsa",
        "Pointer",
        "Aveo",
        "Beetle",
        "Mini cooper"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val itemsAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, modeloCoches)

        listView.adapter = itemsAdapter


        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    applicationContext,
                    "seleccionaste el coche ${modeloCoches[position]}", Toast.LENGTH_SHORT
                )
                    .show()
            }
    }
}
