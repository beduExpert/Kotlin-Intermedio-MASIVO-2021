package org.bedu.themes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, LoginFragment())
                .commit()
        }

        // seteando el appbar como action bar
            //val appBar = findViewById<Toolbar>(R.id.app_bar)
        //this.setSupportActionBar(appBar)

       //setupDrawer(appBar)
    }


    fun navigateTo(fragment: Fragment, addToBackstack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)

        if (addToBackstack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }
/*
    //asignamos las acciones para cada opción del AppBar
    override fun onOptionsItemSelected(item_contact: MenuItem): Boolean {
        var msg = ""

        when(item_contact.itemId){
            R.id.delete -> msg=getString(R.string.delete_element)
            R.id.share -> msg=getString(R.string.sharing_element)
        }

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item_contact)
    }

    private fun setupDrawer(toolbar: Toolbar){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val drawerToggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)
    } */
}