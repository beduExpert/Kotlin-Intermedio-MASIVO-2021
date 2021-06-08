package org.bedu.appbarandnavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // seteando el appbar como action bar
        val appBar = findViewById<Toolbar>(R.id.app_bar)
        this.setSupportActionBar(appBar)

       setupDrawer(appBar)
    }


    //Agregar el menú de opciones al AppBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //asignamos las acciones para cada opción del AppBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg = ""

        when(item.itemId){
            R.id.delete -> msg=getString(R.string.delete_element)
            R.id.share -> msg=getString(R.string.sharing_element)
        }

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawer(toolbar: Toolbar){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val drawerToggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)
    }
}