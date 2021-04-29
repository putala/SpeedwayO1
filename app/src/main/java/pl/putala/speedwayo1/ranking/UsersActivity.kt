package pl.putala.speedwayo1.ranking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.home.ContestActivity
import pl.putala.speedwayo1.login.LoginActivity
import pl.putala.speedwayo1.home.ProfileActivity

class UsersActivity : AppCompatActivity() {

    private val usersVm by viewModels<UsersViewModel>()
    private val adapter = UsersAdapter()
    private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        findViewById<RecyclerView>(R.id.recyclerViewUsers).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewUsers).adapter = adapter

        usersVm.users.observe(this, Observer { list ->
            adapter.setUsers(list)
        })

        refreshApp()

    }


    private fun refreshApp(){
        findViewById<SwipeRefreshLayout>(R.id.refreshLayoutUsers).setOnRefreshListener {
            startActivity(Intent(this, UsersActivity::class.java))
            findViewById<SwipeRefreshLayout>(R.id.refreshLayoutUsers).isRefreshing = false
        }
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
                startActivity(Intent(this, UsersActivity::class.java))
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
