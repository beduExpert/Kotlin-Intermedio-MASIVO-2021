package org.bedu.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import org.bedu.menus.databinding.ActivityPopupMenuBinding

class PopupMenuActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPopupMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.button)
        binding.button.setOnClickListener{
            var popMenu = PopupMenu(this, it)
            popMenu.menuInflater.inflate(R.menu.popmenu, popMenu.menu)
            popMenu.setOnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.item1 -> {
                        Toast.makeText(this, "option 1", Toast.LENGTH_SHORT).show()
                    }
                }
                false
            }
            popMenu.show()
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var inflater = menuInflater
        inflater.inflate(R.menu.popmenu, menu)
    }
}