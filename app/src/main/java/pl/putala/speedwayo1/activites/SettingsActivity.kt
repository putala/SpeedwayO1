package pl.putala.speedwayo1.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.login.LoginActivity

class SettingsActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
//
//        findViewById<Button>(R.id.action_settings1).setOnClickListener {
//            startActivity(Intent(this, ContestActivity::class.java))
//            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
//        }
//
//        findViewById<Button>(R.id.action_settings2).setOnClickListener {
//            startActivity(Intent(this, RankingActivity::class.java))
//            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
//        }

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
            R.id.action_logout -> {
                auth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }



}