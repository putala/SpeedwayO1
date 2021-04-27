package pl.putala.speedwayo1.ranking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.RankingAdapter
import pl.putala.speedwayo1.contest.ContestActivity
import pl.putala.speedwayo1.login.LoginActivity
import pl.putala.speedwayo1.profile.ProfileActivity

class RankingActivity : AppCompatActivity() {

    //    private val usersVm by viewModels<UsersViewModel>
    private val auth = FirebaseAuth.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        findViewById<RecyclerView>(R.id.recyclerViewRanking).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewRanking).adapter = RankingAdapter()
//        findViewById<RecyclerView>(R.id.recyclerViewRanking).setHasFixedSize(true)

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

}