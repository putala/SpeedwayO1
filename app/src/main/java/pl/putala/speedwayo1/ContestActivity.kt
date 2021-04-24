package pl.putala.speedwayo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest)

        val exampleList = generateDummyList(50)

        findViewById<RecyclerView>(R.id.recyclerViewTypes).adapter = ExampleAdapter(exampleList)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).setHasFixedSize(true)

    }


    private fun generateDummyList(size: Int): List<ExampleItem> {

        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_baseline_accessible_forward_24
                1 -> R.drawable.ic_baseline_directions_bike_24
                else -> R.drawable.ic_baseline_moped_24
            }

            val item = ExampleItem(drawable, drawable, "Team $i", "30 : 60", "Team $i", "13 : 12", "01.01.2021")
            list += item
        }

        return list
    }



}