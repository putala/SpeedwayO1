package pl.putala.speedwayo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        findViewById<RecyclerView>(R.id.recyclerViewTypes).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).adapter = ContestAdapter(exampleList)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).setHasFixedSize(true)



    }
}