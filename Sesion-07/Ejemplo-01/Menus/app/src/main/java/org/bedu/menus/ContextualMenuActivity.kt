package org.bedu.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import org.bedu.menus.databinding.ActivityContextualMenuBinding
import org.bedu.menus.databinding.ActivityMainBinding

class ContextualMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContextualMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContextualMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.txTextView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var inflater = menuInflater
        inflater.inflate(R.menu.menu_context, menu)
    }

}