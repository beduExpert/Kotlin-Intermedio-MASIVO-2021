package org.bedu.themes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginButton = view.findViewById<MaterialButton>(R.id.next_button)

        loginButton.setOnClickListener {
            (activity as MainActivity).navigateTo(MainFragment(), false)
        }

        return view
    }

}