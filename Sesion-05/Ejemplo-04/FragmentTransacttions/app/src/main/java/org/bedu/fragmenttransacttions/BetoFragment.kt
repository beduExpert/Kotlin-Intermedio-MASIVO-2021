package org.bedu.fragmenttransacttions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BetoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beto, container, false)
        Log.d("Fragment", "onCreateView llamado BETO")
        return view
    }

    override fun onAttach(context: Context) {
        Log.d("Fragment", "onAttach llamado en BETO")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Fragment", "onCreate llamado BETO")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Fragment", "onActivityCreated llamado BETO")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Fragment", "onStart llamado BETO")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Fragment", "onResume llamado BETO")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Fragment", "onPause llamado BETO")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Fragment", "onStop llamado BETO")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Fragment", "onDestroyView llamado BETO")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("Fragment", "onDestroy llamado BETO")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Fragment", "onDetach llamado BETO")
        super.onDetach()
    }

}