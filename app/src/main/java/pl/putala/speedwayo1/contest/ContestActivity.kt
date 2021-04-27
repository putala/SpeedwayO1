package pl.putala.speedwayo1.contest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.Constant.match
import pl.putala.speedwayo1.Constant.result
import pl.putala.speedwayo1.Constant.teams
import pl.putala.speedwayo1.Constant.teamsImage
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


        findViewById<RecyclerView>(R.id.recyclerViewTypes).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).adapter = ContestAdapter()
//        findViewById<RecyclerView>(R.id.recyclerViewTypes).setHasFixedSize(true)



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
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




}