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

        val exampleList = generateDummyList(8)

        findViewById<RecyclerView>(R.id.recyclerViewTypes).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).adapter = ContestAdapter(exampleList)
        findViewById<RecyclerView>(R.id.recyclerViewTypes).setHasFixedSize(true)



//
//
//        val seek = findViewById<SeekBar>(R.id.seekBarProbny)
//        seek?.setOnSeekBarChangeListener(object :
//            SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
//                // write custom code for progress is changed
//                findViewById<TextView>(R.id.textViewProbny).text = seek.progress.toString()
//            }
//            override fun onStartTrackingTouch(seek: SeekBar) {
//                // write custom code for progress is started
//                findViewById<TextView>(R.id.textViewProbny).text = seek.progress.toString()
//            }
//            override fun onStopTrackingTouch(seek: SeekBar) {
//                // write custom code for progress is stopped
//                findViewById<TextView>(R.id.textViewProbny).text = seek.progress.toString()
//            }
//        })






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


    private fun generateDummyList(size: Int): List<ContestItem> {

        val list = ArrayList<ContestItem>()

        for (i in 0 until size) {
            val item = ContestItem(
                teamsImage[match[i].substring(0, 2).toInt()],
                teamsImage[match[i].substring(2, 4).toInt()],
                "" + teams[match[i].substring(0, 2).toInt()],
                result[i].substring(0, 2) + " : " + result[i].substring(2, 4),
                "" + teams[match[i].substring(2, 4).toInt()],
                "45 : 45",
                "01.01.2021"
            )
            list += item
        }

        return list
    }


//
//
//    protected fun setingResult(
//        suwak: SeekBar,
//        ujscie: TextView
//    ) {
//        suwak.setOnSeekBarChangeListener(
//
//            ujscie.text = suwak.progress.toString()
//
////            object : SeekBar.OnSeekBarChangeListener {
////
////
////
////                override fun onProgressChanged(
////                    seekBar: SeekBar?,
////                    progress: Int,
////                    fromUser: Boolean
////                ) {
////
////                }
////
////                override fun onStartTrackingTouch(seekBar: SeekBar?) {
////                    //
////                }
////
////                override fun onStopTrackingTouch(seekBar: SeekBar?) {
////                    //
////                }
////
////            }
//
//        )


//
//        suwak.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//
//            override fun afterTextChanged(s: Editable?) {
//                if ( suwak.length() > 0 && confirmPassword.length() > 0 && suwak.isFocused && confirmPassword.text.toString() != suwak.text.toString()) {
//                    confirmWarn.visibility = TextView.VISIBLE
//                } else {
//                    confirmWarn.visibility = TextView.INVISIBLE
//                }
//            }
//        })
//        confirmPassword.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//
//            override fun afterTextChanged(s: Editable?) {
//                if ( suwak.length() > 0 && confirmPassword.length() > 0 && confirmPassword.isFocused && confirmPassword.text.toString() != suwak.text.toString()) {
//                    confirmWarn.visibility = TextView.VISIBLE
//                } else {
//                    confirmWarn.visibility = TextView.INVISIBLE
//                }
//            }
//        })
//    }


}