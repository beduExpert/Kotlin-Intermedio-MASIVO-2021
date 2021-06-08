package org.bedu.recyclercontacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_contact.*
import android.app.Activity
import android.content.Intent


class AddContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        buttonAdd.setOnClickListener{
            val name = editName.text.toString()
            val phone = editPhone.text.toString()
            val status = "disponible"
            val imgProfile = R.drawable.unknown

            val contact = Contact(name,status,phone,imgProfile)

            val returnIntent = Intent()
            returnIntent.putExtra("new_contact", contact)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }


}