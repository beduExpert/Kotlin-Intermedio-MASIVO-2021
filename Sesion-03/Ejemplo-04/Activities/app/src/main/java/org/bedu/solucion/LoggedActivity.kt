package org.bedu.solucion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast


class LoggedActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)

        Log.d("activities","onCreate User")

        val textName = findViewById<TextView>(R.id.name)
        val textEmail = findViewById<TextView>(R.id.email)

        val bundle = intent.extras

        val name = bundle?.getString(USER_NAME)
        val email = bundle?.getString(USER_EMAIL)
        val phone = intent.getStringExtra(USER_PHONE)

        textName.text = name
        textEmail.text = email

        Toast.makeText(this,"El telefono es $phone",Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        Log.d("activities","onStart User")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activities","onResume User")
    }

    override fun onPause() {
        Log.d("activities","onPause User")
        super.onPause()
    }

    override fun onStop() {
        Log.d("activities","onStop User")
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activities","onRestart User")
    }

    override fun onDestroy() {
        Log.d("activities","onDestroy User")
        super.onDestroy()
    }

}
