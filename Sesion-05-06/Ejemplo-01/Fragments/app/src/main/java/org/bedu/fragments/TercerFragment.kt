package org.bedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.bedu.fragments.databinding.FragmentTercerBinding

class TercerFragment : Fragment(R.layout.fragment_tercer) {

    private var fragmentBlankBinding: FragmentTercerBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTercerBinding.bind(view)
        fragmentBlankBinding = binding
        binding.txtDriverIdData.text = "Texto completo de prueba"
    }
}