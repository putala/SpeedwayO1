package pl.putala.speedwayo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import pl.putala.speedwayo1.smieci.MainActivity2

class MainActivity : AppCompatActivity() {

    private val TAG: String = "TAG"

//    val buttonRegister: Button = findViewById<Button>(R.id.buttonRegister)
//    val buttonSingIn: Button = findViewById<Button>(R.id.buttonSingIn)
//    val editTextPassword: EditText = findViewById<EditText>(R.id.editTextPassword)
//    val textViewPassword: TextView = findViewById<TextView>(R.id.textViewPassword)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity -> onCreate")

        validationPassword(findViewById(R.id.editTextPassword), findViewById(R.id.textViewPassword))
        validationEmail(findViewById(R.id.editTextEmail), findViewById(R.id.textViewEmail))


    }


//
//    override fun onUserInteraction() {
//        super.onUserInteraction()
//
//        if (findViewById<EditText>(R.id.editTextPassword).isFocused
//            && findViewById<EditText>(R.id.editTextPassword).length() > 1
//            && findViewById<EditText>(R.id.editTextPassword).length() < 5
//        ) {
//            findViewById<TextView>(R.id.textViewPassword).visibility = TextView.VISIBLE
//        } else {
//            findViewById<TextView>(R.id.textViewPassword).visibility = TextView.INVISIBLE
//        }
//    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity -> onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity -> onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity -> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity -> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity -> onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity -> onRestart")
    }


    fun singIn(view: View) {
        startActivity(Intent(this, ContestActivity::class.java))
        Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
    }

    fun singIn2(view: View) {
        startActivity(Intent(this, MainActivity2::class.java))
        Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
    }

    fun register(view: View) {
        startActivity(Intent(this, RegisterActivity::class.java))
        Toast.makeText(this, "Register.", Toast.LENGTH_SHORT).show()
    }

    fun ranking(view: View) {
        startActivity(Intent(this, RankingActivity::class.java))
        Toast.makeText(this, "Ranking.", Toast.LENGTH_SHORT).show()
    }

    fun settings(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
        Toast.makeText(this, "Settings.", Toast.LENGTH_SHORT).show()
    }

    fun brudnopis(view: View) {
        startActivity(Intent(this, BrudnopisActivity::class.java))
        Toast.makeText(this, "Brudnopis.", Toast.LENGTH_SHORT).show()
    }


}