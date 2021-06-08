package org.bedu.buildvariant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.bedu.buildvariant.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginButton = view?.findViewById<Button>(R.id.login_button)

        loginButton?.setOnClickListener {
            Toast.makeText(context,getString(R.string.free_version), Toast.LENGTH_SHORT).show()
        }
        return view
    }
}