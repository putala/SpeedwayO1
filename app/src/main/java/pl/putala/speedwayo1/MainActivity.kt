package pl.putala.speedwayo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG: String = "TAG"

//
//    val buttonRegister: Button = findViewById<Button>(R.id.buttonRegister)
//    val buttonSingIn: Button = findViewById<Button>(R.id.buttonSingIn)
//    val editTextPassword: EditText = findViewById<EditText>(R.id.editTextPassword)
//    val textViewPassword: TextView = findViewById<TextView>(R.id.textViewPassword)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity -> onCreate")


        findViewById<EditText>(R.id.editTextPassword).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                if (findViewById<EditText>(R.id.editTextPassword).isFocused
                    && findViewById<EditText>(R.id.editTextPassword).length() > 0
                    && findViewById<EditText>(R.id.editTextPassword).length() < 5
                ) {
                    findViewById<TextView>(R.id.textViewPassword).visibility = TextView.VISIBLE
                } else {
                    findViewById<TextView>(R.id.textViewPassword).visibility = TextView.INVISIBLE
                }
            }

        })


        findViewById<EditText>(R.id.editTextEmail).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                if (findViewById<EditText>(R.id.editTextEmail).isFocused
                    && findViewById<EditText>(R.id.editTextEmail).length() != 0
                ) {
                    var monkey: Boolean = false
                    for (i in findViewById<EditText>(R.id.editTextEmail).text) {
                        if (i == '@') {
                            monkey = true
                        }
                    }
                    if (monkey) {
                        findViewById<TextView>(R.id.textViewEmail).visibility = TextView.INVISIBLE
                    } else {
                        findViewById<TextView>(R.id.textViewEmail).visibility = TextView.VISIBLE
                    }
                } else {
                    findViewById<TextView>(R.id.textViewEmail).visibility = TextView.INVISIBLE
                }
            }

        })


        findViewById<Button>(R.id.buttonRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            Toast.makeText(this, "Register user.", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.buttonSingIn).setOnClickListener {
            startActivity(Intent(this, ContestActivity::class.java))
            Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
        }


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


}