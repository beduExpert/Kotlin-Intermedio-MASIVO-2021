package org.bedu.buildvariants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.bedu.buildvariants.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.loginButton.setOnClickListener {

            when {
                binding.editUser.text.toString() == "" -> {
                    Toast.makeText(context,getString(R.string.user_empty), Toast.LENGTH_SHORT).show()
                }
                binding.editPassword.text.toString() == "" -> {
                    Toast.makeText(context,getString(R.string.pass_empty), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(context,getString(R.string.login_successful), Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}