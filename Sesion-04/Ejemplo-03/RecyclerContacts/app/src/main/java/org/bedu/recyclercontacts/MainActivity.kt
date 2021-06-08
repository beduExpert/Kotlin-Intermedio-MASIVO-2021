package org.bedu.recyclercontacts

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //configuración de RecyclerView
        setUpRecyclerView()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView(){
        recyclerContacts.setHasFixedSize(true)
        //nuestro layout va a ser de una sola columna
        recyclerContacts.layoutManager = LinearLayoutManager(this)
        //seteando el Adapter
        mAdapter = RecyclerAdapter( this,getContacts())
        //asignando el Adapter al RecyclerView
        recyclerContacts.adapter = mAdapter
    }

    //generamos datos dummy con este método
    private fun getContacts(): MutableList<Contact>{
        var contacts:MutableList<Contact> = ArrayList()

        contacts.add(Contact("Pablo Perez", "disponible", "5535576823",R.drawable.unknown))
        contacts.add(Contact("Juan Magaña", "on smash", "553552432",R.drawable.unknown))
        contacts.add(Contact("Leticia Pereda", "disponible", "5553454363",R.drawable.unknown))
        contacts.add(Contact("Manuel Lozano", "livin' la vida loca", "9613245432",R.drawable.unknown))
        contacts.add(Contact("Ricardo Belmonte", "disponible", "6332448739",R.drawable.unknown))
        contacts.add(Contact("Rosalina", "lookin' to the stars", "7546492750",R.drawable.unknown))
        contacts.add(Contact("Thalía Fernandez", "no fear", "5587294655",R.drawable.unknown))
        contacts.add(Contact("Sebastián Cárdenas", "no molestar", "4475655578",R.drawable.unknown))

        return contacts
    }

    //Funciones predeterminadas por Android Studio
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
