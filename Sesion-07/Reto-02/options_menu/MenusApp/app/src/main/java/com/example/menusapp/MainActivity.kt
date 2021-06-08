package com.example.menusapp

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
            R.id.item1 -> {
                if (item.isChecked) {
                    Toast.makeText(this, "Item1 Checked", Toast.LENGTH_SHORT).show()
                    item.setChecked(false)
                } else {
                    Toast.makeText(this, "Item1 Not Checked", Toast.LENGTH_SHORT).show()
                    item.setChecked(true)
                }
                return true
            }
            R.id.item2 -> {
                if (item.isChecked) {
                    Toast.makeText(this, "Item2 Checked", Toast.LENGTH_SHORT).show()
                    item.setChecked(false)
                } else {
                    Toast.makeText(this, "Item2 Not Checked", Toast.LENGTH_SHORT).show()
                    item.setChecked(true)
                }
                return true
            }
            R.id.item3 -> {
                if (item.isChecked) {
                    Toast.makeText(this, "Item3 Checked", Toast.LENGTH_SHORT).show()
                    item.setChecked(false)
                } else {
                    Toast.makeText(this, "Item3 Not Checked", Toast.LENGTH_SHORT).show()
                    item.setChecked(true)
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}