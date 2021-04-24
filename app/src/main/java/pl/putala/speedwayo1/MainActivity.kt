package pl.putala.speedwayo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG: String = "TAG"
//    private val buttonRegister: Button = findViewById<Button>(R.id.buttonRegister)
//    private val buttonSingIn: Button = findViewById<Button>(R.id.buttonSingIn)
//    private val editTextPassword: EditText = findViewById<EditText>(R.id.editTextPassword)
//    private val textViewPassword: TextView = findViewById<TextView>(R.id.textViewPassword)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity -> onCreate")


        findViewById<Button>(R.id.buttonRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            Toast.makeText(this, "Register user.", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.buttonSingIn).setOnClickListener {
            startActivity(Intent(this, ContestActivity::class.java))
            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
        }


    }


    override fun onUserInteraction() {
        super.onUserInteraction()

        if (findViewById<EditText>(R.id.editTextPassword).isFocused
            && findViewById<EditText>(R.id.editTextPassword).length() > 1
            && findViewById<EditText>(R.id.editTextPassword).length() < 5
        ) {
            findViewById<TextView>(R.id.textViewPassword).visibility = TextView.VISIBLE
        } else {
            findViewById<TextView>(R.id.textViewPassword).visibility = TextView.INVISIBLE
        }
    }


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


}