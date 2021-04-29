package pl.putala.speedwayo1.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.contest.ContestAdapter
import pl.putala.speedwayo1.ranking.UsersActivity
import pl.putala.speedwayo1.login.LoginActivity
import java.util.*

class ContestActivity : AppCompatActivity() {

    private val TAG_CON: String = "TAG_CON"
    private val fbAuth = FirebaseAuth.getInstance()
    private val adapter = ContestAdapter()
    private val adminVm by viewModels<AdminViewModel>()
    private val userVm by viewModels<ProfileViewModel>()
    private val PROFILE_DEBUG = "PROFILE_DEBUG"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest)

        Log.d(TAG_CON, "MainActivity -> onCreate")

        findViewById<RecyclerView>(R.id.recyclerViewTypes).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).adapter = adapter

        userVm.user.observe(this, { user ->
            Log.d(PROFILE_DEBUG, user.toString())
            adapter.getUser(user)
//            adapter.editUser(userVm)
        })

        adminVm.admin.observe(this, {admin ->
            Log.d(PROFILE_DEBUG, admin.toString())
            adapter.setAdmin(admin)
        })

    }



    override fun onStart() {
        super.onStart()
        Log.d(TAG_CON, "ContestActivity -> onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG_CON, "ContestActivity -> onResume")
    }

    override fun onPause() {
        super.onPause()
//        adapter.editUser(userVm)
        Log.d(TAG_CON, "ContestActivity -> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG_CON, "ContestActivity -> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG_CON, "ContestActivity -> onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG_CON, "ContestActivity -> onRestart")
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_contest -> {
                adapter.editUser(userVm)
                startActivity(Intent(this, ContestActivity::class.java))
            }
            R.id.action_ranking -> {
                adapter.editUser(userVm)
                startActivity(Intent(this, UsersActivity::class.java))
            }
            R.id.action_settings -> {
                adapter.editUser(userVm)
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            R.id.action_logout -> {
                adapter.editUser(userVm)
                fbAuth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }



}