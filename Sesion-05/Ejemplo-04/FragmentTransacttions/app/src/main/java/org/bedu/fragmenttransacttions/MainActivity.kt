package org.bedu.fragmenttransacttions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Error

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager

        //Agregaremos un nuevo Fragment
        addButton.setOnClickListener {
            val fragment = BeduFragment()
            val transaction = manager.beginTransaction()
            transaction.add(R.id.container, fragment, "fragBedu")
            transaction.commit()
        }

        removeButton.setOnClickListener {

            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if(fragmentTag!=null){
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.remove(fragment)
                transaction.commit()
            } else{
                Toast.makeText(this, "No hay ningún FragmentBedu agregado",Toast.LENGTH_SHORT).show()
            }
        }


        hideButton.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if(fragmentTag!=null){
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.hide(fragment)
                transaction.commit()
            } else{
                Toast.makeText(this, "No hay ningún FragmentBedu agregado",Toast.LENGTH_SHORT).show()
            }
        }

        showButton.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if(fragmentTag!=null){
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.show(fragment)
                transaction.commit()
            } else{
                Toast.makeText(this, "No hay ningún FragmentBedu agregado",Toast.LENGTH_SHORT).show()
            }
        }

        detachButton.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if(fragmentTag!=null){
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.detach(fragment)
                transaction.commit()
            } else{
                Toast.makeText(this, "No hay ningún FragmentBedu agregado",Toast.LENGTH_SHORT).show()
            }
        }

        attachButton.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBedu")

            if(fragmentTag!=null){
                val fragment = fragmentTag as BeduFragment
                val transaction = manager.beginTransaction()
                transaction.attach(fragment)
                transaction.commit()
            } else{
                Toast.makeText(this, "No hay ningún FragmentBedu agregado",Toast.LENGTH_SHORT).show()
            }
        }

        add2Button.setOnClickListener {
            val fragment = BetoFragment()
            val transaction = manager.beginTransaction()
            transaction.add(R.id.container, fragment, "fragBeto")
            transaction.commit()
        }

        remove2Button.setOnClickListener {
            val fragmentTag = manager.findFragmentByTag("fragBeto")

            if(fragmentTag!=null){
                val fragment = fragmentTag as BetoFragment
                val transaction = manager.beginTransaction()
                transaction.remove(fragment)
                transaction.commit()
            } else{
                Toast.makeText(this, "No hay ningún FragmentBeto agregado",Toast.LENGTH_SHORT).show()
            }
        }

        replace1Button.setOnClickListener {
            val beduFragment = BeduFragment()
            val transaction = manager.beginTransaction()
            transaction
                .replace(R.id.container,beduFragment,"fragBedu")
                .commit()
        }

        replace2Button.setOnClickListener {
            val betoFragment = BetoFragment()
            val transaction = manager.beginTransaction()
            transaction
                .replace(R.id.container,betoFragment,"fragBeto")
                .commit()
        }

    }
}