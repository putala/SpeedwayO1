package pl.putala.speedwayo1.activites

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import pl.putala.speedwayo1.*
import pl.putala.speedwayo1.contest.ContestActivity
import pl.putala.speedwayo1.login.LoginActivity
import pl.putala.speedwayo1.ranking.RankingActivity
import pl.putala.speedwayo1.profile.ProfileActivity

class MainActivity : BaseActivity() {

//
//    private val fbAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//
//    override fun onStart() {
//        super.onStart()
//        isCurrentUser()
//    }
//
//    private fun isCurrentUser() {
//        fbAuth.currentUser?.let {auth ->
//            startApp()
//        }
//    }



    fun buttonStart(view: View) {
        startActivity(Intent(this, ContestActivity::class.java))
        Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
    }


    fun ranking(view: View) {
        startActivity(Intent(this, RankingActivity::class.java))
        Toast.makeText(this, "Ranking.", Toast.LENGTH_SHORT).show()
    }

    fun settings(view: View) {
        startActivity(Intent(this, ProfileActivity::class.java))
        Toast.makeText(this, "Settings.", Toast.LENGTH_SHORT).show()
    }

    fun brudnopis(view: View) {
        startActivity(Intent(this, BrudnopisActivity::class.java))
        Toast.makeText(this, "Brudnopis.", Toast.LENGTH_SHORT).show()
    }

    fun login(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
        Toast.makeText(this, "Brudnopis.", Toast.LENGTH_SHORT).show()
    }


}