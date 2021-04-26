package pl.putala.speedwayo1.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.BaseActivity
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.registration.RegistrationActivity
import pl.putala.speedwayo1.smieci.MainActivity2


class LoginActivity : BaseActivity() {

    private val TAG: String = "TAG"
    private val LOG_DEBUG = "LOG_DEBUG"
//    private var validtion: Boolean = false
    private val fbAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d(TAG, "MainActivity -> onCreate")

        validationEmail(findViewById(R.id.editTextEmail), findViewById(R.id.textViewEmail))
        validationPassword(findViewById(R.id.editTextPassword), findViewById(R.id.textViewPassword))

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
        startActivity(Intent(this, RegistrationActivity::class.java))
        Toast.makeText(this, "Register.", Toast.LENGTH_SHORT).show()
    }


    fun singIn(view: View) {
        val emailET: EditText = findViewById(R.id.editTextEmail)
        val email = emailET.text?.trim().toString()
        val passET: EditText = findViewById(R.id.editTextPassword)
        val pass = emailET.text?.trim().toString()

        fbAuth.signInWithEmailAndPassword(email, pass)
            .addOnSuccessListener { authRes ->
                if (authRes.user != null) {
                    startApp()
                    Toast.makeText(this, email, Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exc ->
                Toast.makeText(this, "Upsss... Coś poszło nie tak!", Toast.LENGTH_SHORT).show()
                Log.d(LOG_DEBUG, exc.message.toString())
            }
    }


    fun singIn2(view: View) {
        startActivity(Intent(this, MainActivity2::class.java))
        Toast.makeText(this, "Open app.", Toast.LENGTH_SHORT).show()
    }


}