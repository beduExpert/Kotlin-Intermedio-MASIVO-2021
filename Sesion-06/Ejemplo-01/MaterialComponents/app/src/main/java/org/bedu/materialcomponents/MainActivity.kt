package org.bedu.materialcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var nextButton: MaterialButton
    private lateinit var cancelButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton = findViewById(R.id.next_button)
        cancelButton = findViewById(R.id.cancel_button)

        nextButton.setOnClickListener{
            Toast.makeText(this,getString(R.string.accept),Toast.LENGTH_SHORT).show()
        }

        cancelButton.setOnClickListener{
            Toast.makeText(this,getString(R.string.cancel),Toast.LENGTH_SHORT).show()
        }
    }
}