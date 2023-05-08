package org.bedu.menussolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.item2, R.id.item3 -> {
                setCheckbox(item)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setCheckbox(item: MenuItem) {
        if (item.isChecked) {
            Toast.makeText(this, "${item.title} set to Unchecked", Toast.LENGTH_SHORT).show()
            item.setChecked(false)
        } else {
            Toast.makeText(this, "${item.title} set to Checked", Toast.LENGTH_SHORT).show()
            item.setChecked(true)
        }
    }
}