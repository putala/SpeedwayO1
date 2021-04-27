package pl.putala.speedwayo1.contest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.ranking.RankingActivity
import pl.putala.speedwayo1.login.LoginActivity
import pl.putala.speedwayo1.profile.ProfileActivity

class ContestActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

//    private val contestVm by viewModels<ContestViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest)

        val exampleList = generateDummyList(50)

        findViewById<RecyclerView>(R.id.recyclerViewTypes).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).adapter = ContestAdapter(exampleList)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).setHasFixedSize(true)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_contest -> {
                startActivity(Intent(this, ContestActivity::class.java))
            }
            R.id.action_ranking -> {
                startActivity(Intent(this, RankingActivity::class.java))
            }
            R.id.action_settings -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            R.id.action_logout -> {
                auth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
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


}