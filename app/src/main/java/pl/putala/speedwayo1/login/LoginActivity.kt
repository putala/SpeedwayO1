package pl.putala.speedwayo1.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.BaseActivity
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.registration.RegistrationActivity


class LoginActivity : BaseActivity() {

    private val TAG: String = "TAG"
    private val LOG_DEBUG = "LOG_DEBUG"
    private val fbAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d(TAG, "MainActivity -> onCreate")

        validationEmail(findViewById(R.id.editTextEmail), findViewById(R.id.textViewEmail))
        validationText(findViewById(R.id.editTextPassword), findViewById(R.id.textViewPassword))
//
//        userVm.user.observe(this, Observer { user -> bindUserData(user) })

    }

//
//    private fun bindUserData(user: User) {
//        Log.d(USER_DEBUG, user.toString())
//        findViewById<TextView>(R.id.textViewNameS).text = user.name
//        findViewById<TextView>(R.id.textViewEmailS).text = user.email
//        findViewById<TextView>(R.id.textViewPointsSumS).text = user.sumOfPoints
//
//    }

    override fun onStart() {
        super.onStart()
        isCurrentUser()
        Log.d(TAG, "MainActivity -> onStart")
    }

    private fun isCurrentUser() {
        fbAuth.currentUser?.let { startApp() }
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
        val email = (findViewById<EditText>(R.id.editTextEmail)).text?.trim().toString()
        val pass = (findViewById<EditText>(R.id.editTextPassword)).text?.trim().toString()

        if (findViewById<TextView>(R.id.textViewEmail).visibility == TextView.INVISIBLE
            && findViewById<TextView>(R.id.textViewPassword).visibility == TextView.INVISIBLE
            && email.isNotEmpty() && pass.isNotEmpty()) {
            fbAuth.signInWithEmailAndPassword(email, pass)
                .addOnSuccessListener { authRes ->
                    if (authRes.user != null) {
                        startApp()
                        Toast.makeText(this, "You are logged id!!!", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener { exc ->
                    Toast.makeText(this, "Ops... something went wrong!", Toast.LENGTH_SHORT).show()
                    Log.d(LOG_DEBUG, exc.message.toString())
                }
        }
    }


}