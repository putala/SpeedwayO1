package pl.putala.speedwayo1.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.contest.ContestAdapter
import pl.putala.speedwayo1.data.Admin
import pl.putala.speedwayo1.data.User
import pl.putala.speedwayo1.ranking.UsersActivity
import pl.putala.speedwayo1.login.LoginActivity
import java.util.Observer

class ContestActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    private val adapter = ContestAdapter()
//    private val adminVm by viewModels<AdminViewModel>()
    private val PROFILE_DEBUG = "PROFILE_DEBUG"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest)


        findViewById<RecyclerView>(R.id.recyclerViewTypes).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).adapter = adapter



//        adminVm.admin.observe(this, { admin -> adapter.setAdmin(admin) })
//
//        homeVm.users.observe(this, Observer { list ->
//            adapter.setUsers(list)
//        })

//        profileVm.user.observe(this, Observer { user -> bindUserData(user) })
//

    }


//
//    private fun bindAdminData(admin: Admin) {
//        Log.d(PROFILE_DEBUG, admin.toString())
//        mecze = admin.teams
//    }


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