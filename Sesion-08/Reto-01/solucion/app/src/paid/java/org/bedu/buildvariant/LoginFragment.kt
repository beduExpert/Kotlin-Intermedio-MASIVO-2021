package org.bedu.buildvariant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginButton = view?.findViewById<Button>(R.id.login_button)
        val editUser = view?.findViewById<EditText>(R.id.edit_user)
        val editPassword = view?.findViewById<EditText>(R.id.edit_password)

        loginButton?.setOnClickListener {

            when {
                editUser?.text.toString() == "" -> {
                    Toast.makeText(context,getString(R.string.user_empty), Toast.LENGTH_SHORT).show()
                }
                editPassword?.text.toString() == "" -> {
                    Toast.makeText(context,getString(R.string.pass_empty), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(context,getString(R.string.login_successful), Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }
}