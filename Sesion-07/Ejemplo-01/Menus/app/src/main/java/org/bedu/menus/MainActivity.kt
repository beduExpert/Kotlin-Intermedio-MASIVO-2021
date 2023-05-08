package org.bedu.menus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import org.bedu.menus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.optionsMenuButton.setOnClickListener{
            startActivity(Intent(this, OptionsMenuActivity::class.java))
        }

        binding.contextualMenuButton.setOnClickListener{
            startActivity(Intent(this, ContextualMenuActivity::class.java))
        }

        binding.popupMenuButton.setOnClickListener{
            startActivity(Intent(this, PopupMenuActivity::class.java))
        }
    }


}