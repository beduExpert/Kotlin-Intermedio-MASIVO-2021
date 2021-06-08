package org.bedu.spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    lateinit var selectedCountry: CountryModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countries = getCountries()

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //se reproduce si no se seleccionó nada
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext, "No idioma" , Toast.LENGTH_LONG).show()
            }
            // se reproduce si se seleccionó un elemento
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                button.visibility = Button.VISIBLE

                selectedCountry = countries[position]
                button.text =  selectedCountry.next
                tvTitle.text = selectedCountry.selCountry

            }
        }

        button.setOnClickListener{
            showDialog("",selectedCountry.thanks)
        }


        val countryAdapter= CountryAdapter(this, countries)
        spinner.adapter = countryAdapter

    }

    private fun getCountries(): ArrayList<CountryModel>{
        val countryModels = arrayListOf(
            CountryModel("Mexico",R.drawable.mexico, "Continuar", "Muchas gracias","Selecciona tu país"),
            CountryModel("Brasil",R.drawable.brazil, "Continuar", "Muito obrigado"," Selecione seu país"),
            CountryModel("Francia",R.drawable.france, "Continuez", "Merci beaucoup", "Sélectionnez votre pays"),
            CountryModel("Alemania",R.drawable.germany, "FortFühren", "Danke sehr", "Wählen Sie Ihr Land aus"),
            CountryModel("Italia",R.drawable.italy, "Continuare", "Molto grazie", "Seleziona il tuo paese"),
            CountryModel("United states",R.drawable.united_states, "Next", "Thank you", "Select your country")
        )

        return countryModels
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
