package hu.prooktatas.olimpics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.prooktatas.olimpics.gamelistadapter.GameItemClickHandler
import hu.prooktatas.olimpics.gamelistadapter.GameListAdapter
import hu.prooktatas.olimpics.model.GameInfo

class GameListActivity : AppCompatActivity(), GameItemClickHandler {
    private lateinit var recyclerView: RecyclerView

    val allGames = listOf(
        GameInfo(
            "France",
             "Paris",
            1939
        ),
        GameInfo(
            "Greece",
            "Athen",
            1896
        ),
        GameInfo(
            "Belgium",
            "Antwerpen",
            1920
        ),
        GameInfo(
            "Neatherland",
            "Amsterdam",
            1939
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_list)
        recyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GameListAdapter(allGames,this)

        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun itemClicked() {
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }
}

//TODO nagyobb betűk
//TODO több jelenjen meg

const val TAG = "OLY"