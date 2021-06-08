package org.bedu.solucion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView


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
            } else{
                image.setImageResource(R.drawable.wrong)
            }
        }

    }
}
