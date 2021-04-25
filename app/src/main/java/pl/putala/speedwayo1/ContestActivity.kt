package pl.putala.speedwayo1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest)

        val exampleList = generateDummyList(50)

        findViewById<RecyclerView>(R.id.recyclerViewTypes).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).adapter = ContestAdapter(exampleList)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).setHasFixedSize(true)


//
//        findViewById<Button>(R.id.action_settings2).setOnClickListener {
//            startActivity(Intent(this, RankingActivity::class.java))
//            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
//        }
//
//        findViewById<Button>(R.id.action_settings3).setOnClickListener {
//            startActivity(Intent(this, SettingsActivity::class.java))
//            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
//        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Napompuj menu; spowoduje to dodanie elementów do paska akcji, jeśli jest obecny.
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }


    private fun generateDummyList(size: Int): List<ExampleItem> {

        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_baseline_accessible_forward_24
                1 -> R.drawable.ic_baseline_directions_bike_24
                else -> R.drawable.ic_baseline_moped_24
            }

            val item = ExampleItem(
                drawable,
                drawable,
                "Team $i",
                "30 : 60",
                "Team $i",
                "13 : 12",
                "01.01.2021"
            )
            list += item
        }

        return list
    }

    fun openContest(item: MenuItem) {}


}