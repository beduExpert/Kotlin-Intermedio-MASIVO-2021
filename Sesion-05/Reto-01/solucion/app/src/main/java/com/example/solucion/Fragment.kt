package com.example.solucion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class ExampleFragment : Fragment() {

    override fun onAttach(context: Context) {
        Log.d("Fragment", "onAttach llamado")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Fragment", "onCreate llamado")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_layout, container, false)

        Log.d("Fragment", "onCreateView llamado")
        val btn = root.findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val intent = Intent(activity, OtherActivity::class.java)
            startActivity(intent)
        }


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Fragment", "onActivityCreated llamado")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Fragment", "onStart llamado")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Fragment", "onResume llamado")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Fragment", "onPause llamado")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Fragment", "onStop llamado")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Fragment", "onDestroyView llamado")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("Fragment", "onDestroy llamado")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Fragment", "onDetach llamado")
        super.onDetach()
    }
}