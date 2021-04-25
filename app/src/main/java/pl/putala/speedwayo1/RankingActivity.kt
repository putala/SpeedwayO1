package pl.putala.speedwayo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)


        findViewById<Button>(R.id.action_settings1).setOnClickListener {
            startActivity(Intent(this, ContestActivity::class.java))
            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.action_settings3).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
        }



    }
}