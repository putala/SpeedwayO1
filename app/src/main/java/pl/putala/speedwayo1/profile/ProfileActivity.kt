package pl.putala.speedwayo1.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.contest.ContestActivity
import pl.putala.speedwayo1.data.User
import pl.putala.speedwayo1.ranking.RankingActivity
import pl.putala.speedwayo1.login.LoginActivity

class ProfileActivity : AppCompatActivity() {


    private val profileVm by viewModels<ProfileViewModel>()
    //    private lateinit var viewModel: ProfileViewModel

    private val PROFILE_DEBUG = "PROFILE_DEBUG"
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        profileVm.user.observe(this, Observer { user -> bindUserData(user) })

        val language = resources.getStringArray(R.array.language)
        val spinner = findViewById<Spinner>(R.id.spinnerLanguage)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, language)
        spinner.adapter = adapter



        val seek = findViewById<SeekBar>(R.id.seekBarProbny)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                findViewById<TextView>(R.id.textViewProbny).text = seek.progress.toString()
            }
            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
                findViewById<TextView>(R.id.textViewProbny).text = seek.progress.toString()
            }
            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                findViewById<TextView>(R.id.textViewProbny).text = seek.progress.toString()
            }
        })


    }



    private fun bindUserData(user: User) {
        Log.d(PROFILE_DEBUG, user.toString())
        findViewById<TextView>(R.id.textViewNameS).text = user.name
        findViewById<TextView>(R.id.textViewEmailS).text = user.email
        findViewById<TextView>(R.id.textViewPointsSumS).text = user.sumOfPoints

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