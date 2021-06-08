package org.bedu.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnAccept: Button
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAccept = findViewById(R.id.btnAccept)
        text = findViewById(R.id.text)

        btnAccept.setOnClickListener {
            text.text = getString(R.string.button_clicked)
            text.visibility = View.INVISIBLE
            btnAccept.isEnabled = false
        }


    }
}
