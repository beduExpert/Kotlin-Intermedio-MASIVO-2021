package org.bedu.solucion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

const val USER_NAME = "org.bedu.activities.USER_NAME"
const val USER_EMAIL = "org.bedu.activities.USER_EMAIL"
const val USER_PHONE = "org.bedu.activities.USER_PHONE"

class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var editName: EditText
    private lateinit var editLastName: EditText
    private lateinit var editPhone: EditText
    private lateinit var editEmail: EditText
    private lateinit var buttonAccept: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("activities","onCreate Login")

        image = findViewById(R.id.image)
        editName = findViewById(R.id.editName)
        editLastName = findViewById(R.id.editLName)
        editPhone = findViewById(R.id.editPhone)
        editEmail = findViewById(R.id.editEmail)
        buttonAccept = findViewById(R.id.buttonAccept)

        buttonAccept.setOnClickListener {
            if(
                editName.text.toString() != "" &&
                editLastName.text.toString() != "" &&
                editPhone.text.toString() != "" &&
                editEmail.text.toString() != ""
                    ){
                image.setImageResource(R.drawable.correct)


                val bundle = Bundle()

                // todas las variables que no son String llaman al método toString()
                val fullName = "${editName.text} ${editLastName.text}"

                bundle.putString(USER_NAME, editName.text.toString())
                bundle.putString(USER_EMAIL, fullName)

                val intent = Intent(this, LoggedActivity::class.java).apply {
                    putExtras(bundle)
                    putExtra(USER_PHONE,editPhone.text.toString())
                }

                startActivity(intent)


            } else{
                image.setImageResource(R.drawable.wrong)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("activities","onStart Login")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activities","onResume Login")
    }

    override fun onPause() {
        Log.d("activities","onPause Login")
        super.onPause()
    }

    override fun onStop() {
        Log.d("activities","onStop Login")
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activities","onRestart Login")
    }

    override fun onDestroy() {
        Log.d("activities","onDestroy Login")
        super.onDestroy()
    }
}
