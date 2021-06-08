package org.bedu.spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    var language = arrayOf("Inglés", "Español", "Chino", "Ruso", "Coreano", "Alemán", "Francés", "Holandés")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //se reproduce si no se seleccionó nada
            override fun onNothingSelected(parent: AdapterView<*>?) {
                showDialog("No seleccionaste idioma","Vuelve a desplegar la lista y asegúrate de elegir correctamente a alguna")
                Toast.makeText(applicationContext, "No idioma" , Toast.LENGTH_LONG).show()
            }
            // se reproduce si se seleccionó un elemento
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext ,language[position] , Toast.LENGTH_LONG).show()
            }
        }

        //Similar al ListView del Ejemplo 1, usaremos un ArrayAdapter con un layout prefabricado
        //el layout simple_spinner_item es el layout del item cuando esta seleccionado
        val languageAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, language)

        //Seteamos el layout de un Item cuando el Spinner está desplegado
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //el adaptador es asignado al spinner
        spinner.adapter = languageAdapter

    }

    private fun showDialog(title:String,message:String){
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK"){_, _->  }

        val alertDialog = builder.create()
            alertDialog.show()
    }
}
