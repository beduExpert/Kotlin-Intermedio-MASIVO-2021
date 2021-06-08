package com.example.actionmodesapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode

class MainActivity : AppCompatActivity() {

    private var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView: TextView = findViewById(R.id.txTextView)
        textView.setOnLongClickListener {
            if (actionMode == null) actionMode = startSupportActionMode(ActionModeCallback())
            true
        }
    }

    inner class ActionModeCallback: ActionMode.Callback {
            var shouldResetRecyclerView = true
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                when (item?.getItemId()) {
                    R.id.option_1 -> {
                        actionMode?.setTitle("Option1") //remove item count from action mode.
                        //actionMode?.finish()
                        return true
                    }
                }
                return false
            }

            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                val inflater = mode?.getMenuInflater()
                inflater?.inflate(R.menu.menu, menu)
                mode?.setTitle("Options Menu")
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                menu?.findItem(R.id.option_2)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                return true
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                actionMode = null
            }
        }
}