package pl.putala.speedwayo1.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.BaseActivity
import pl.putala.speedwayo1.activites.ContestActivity
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.registration.RegisterActivity
import pl.putala.speedwayo1.smieci.MainActivity2
import pl.putala.speedwayo1.validationEmail
import pl.putala.speedwayo1.validationPassword

class LoginActivity : BaseActivity() {

    private val TAG: String = "TAG"
    private val fbAuth = FirebaseAuth.getInstance()
    private val emailET : EditText = findViewById(R.id.editTextEmail)
    private val email = emailET.text?.trim().toString()
    private val passET : EditText = findViewById(R.id.editTextPassword)
    private val pass = emailET.text?.trim().toString()
    private val LOG_DEBUG = "LOG_DEBUG"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d(TAG, "MainActivity -> onCreate")

        validationPassword(passET, findViewById(R.id.textViewPassword))
        validationEmail(emailET, findViewById(R.id.textViewEmail))

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



    fun register(view: View) {
        startActivity(Intent(this, RegisterActivity::class.java))
        Toast.makeText(this, "Register.", Toast.LENGTH_SHORT).show()
    }

    fun singIn(view: View) {

        fbAuth.signInWithEmailAndPassword(email, pass)
            .addOnSuccessListener {

                startApp()

                Toast.makeText(this, email, Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exc ->
                Log.d(LOG_DEBUG, exc.message.toString())
            }


    }



    fun singIn2(view: View) {
        startActivity(Intent(this, MainActivity2::class.java))
        Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
    }



}