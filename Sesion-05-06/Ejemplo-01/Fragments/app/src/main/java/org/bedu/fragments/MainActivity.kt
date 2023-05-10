package org.bedu.fragments

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.bedu.fragments.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val primerFragment=PrimerFragment()
    val segundoFragment=SegundoFragment()
    val tercerFragment=TercerFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(primerFragment)
        createFragments()
    }

    private fun createFragments(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->{
                    setCurrentFragment(primerFragment)
                    true
                }
                R.id.nav_driver->{
                    setCurrentFragment(segundoFragment)
                    true
                }

                R.id.nav_history->{
                    val args = Bundle()
                    val shared: SharedPreferences = getSharedPreferences("shared", MODE_PRIVATE)
                    args.putInt("idConductor", shared.getInt("idConductor",0))
                    args.putString("token", shared.getString("token","0"))
                    tercerFragment.arguments=args
                    setCurrentFragment(tercerFragment)
                    true
                }
                else -> false
            }
        }
//        bottomNavigationView.getOrCreateBadge(R.id.nav_home).apply {
//            isVisible=true
//            number=8
//        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView,fragment)
            commit()
        }
    }
}