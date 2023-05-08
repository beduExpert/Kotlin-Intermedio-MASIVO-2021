package org.bedu.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import org.bedu.menus.databinding.ActivityPopupMenuBinding

class PopupMenuActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPopupMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.button)
        binding.button.setOnClickListener(this)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var inflater = menuInflater
        inflater.inflate(R.menu.popmenu, menu)
    }

    override fun onClick(v: View?) {
        var popMenu = PopupMenu(this, v)
        popMenu.menuInflater.inflate(R.menu.popmenu, popMenu.menu)
        popMenu.show()
    }
}