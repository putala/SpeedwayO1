package pl.putala.speedwayo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)



        findViewById<Button>(R.id.action_settings1).setOnClickListener {
            startActivity(Intent(this, ContestActivity::class.java))
            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.action_settings2).setOnClickListener {
            startActivity(Intent(this, RankingActivity::class.java))
            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
        }


    }
}