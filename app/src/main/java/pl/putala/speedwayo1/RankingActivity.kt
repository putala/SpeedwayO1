package pl.putala.speedwayo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

//        val exampleList2 = generateDummyList(5)

        findViewById<RecyclerView>(R.id.recyclerViewRanking).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewRanking).adapter = RankingAdapter()

//        findViewById<RecyclerView>(R.id.recyclerViewRanking).setHasFixedSize(true)



    }
}