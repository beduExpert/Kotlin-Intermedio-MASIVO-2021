package org.bedu.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gameList = getGames()

        val itemsAdapter = GameAdapter(this,gameList)

        listView.adapter = itemsAdapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val gameName = gameList[position].title
                val category = gameList[position].category
                Toast.makeText(
                    applicationContext,
                    "$gameName ganó en la categoría $category", Toast.LENGTH_SHORT
                )
                    .show()
            }
    }


    private fun getGames(): ArrayList<GameModel>{
        val gameModels = arrayListOf(
            GameModel("Call of duty","Audio design", "Mature",3.5f,R.drawable.call_of_duty),
            GameModel("Control","Art direction", "Everyone",4.5f,R.drawable.control),
            GameModel("Destiny 2","Community support", "Everyone",3.7f,R.drawable.destiny2),
            GameModel("Devil may cry 5","Action game", "Teen",4.2f,R.drawable.devil_may_cry_5),
            GameModel("Sekiro: shadows dies twice","Game of the year","Only Adults",3.0f,R.drawable.sekiro),
            GameModel("Super smash bros ultimate","Fighting game", "Everyone",4.9f,R.drawable.smash)
        )

        return gameModels
    }

}



