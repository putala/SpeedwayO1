package pl.putala.speedwayo1.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.BaseActivity
import pl.putala.speedwayo1.login.LoginActivity
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.data.User
import pl.putala.speedwayo1.ranking.UsersViewModel
import java.util.*


class RegistrationActivity : BaseActivity() {

    private val REG_DEBUG = "REG_DEBUG"
    private val fbAuth = FirebaseAuth.getInstance()
    private val regVm by viewModels<RegistrationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        validationText(
            findViewById(R.id.editTextNameSave),
            findViewById(R.id.textViewNameSave)
        )
        validationEmail(
            findViewById(R.id.editTextEmailSave),
            findViewById(R.id.textViewEmailSave)
        )
        validationText(
            findViewById(R.id.editTextPasswordSave),
            findViewById(R.id.textViewPasswordSave)
        )
        validationPassword(
            findViewById(R.id.editTextPasswordSave),
            findViewById(R.id.editTextConfirmPasswordSave),
            findViewById(R.id.textViewConfirmPasswordSave)
        )
    }


    fun save(view: View) {
        val nicknameSave = (findViewById<EditText>(R.id.editTextNameSave))
            .text?.trim().toString()
        val emailSave = (findViewById<EditText>(R.id.editTextEmailSave))
            .text?.trim().toString()
        val passSave = (findViewById<EditText>(R.id.editTextPasswordSave))
            .text?.trim().toString()
        val confPassSave = (findViewById<EditText>(R.id.editTextConfirmPasswordSave))
            .text?.trim().toString()
        if (findViewById<CheckBox>(R.id.checkBoxRegulations).isChecked) {
            findViewById<TextView>(R.id.textViewRegulations).visibility = TextView.INVISIBLE
            if (findViewById<TextView>(R.id.textViewNameSave).visibility == TextView.INVISIBLE
                && findViewById<TextView>(R.id.textViewEmailSave).visibility == TextView.INVISIBLE
                && findViewById<TextView>(R.id.textViewPasswordSave).visibility == TextView.INVISIBLE
                && findViewById<TextView>(R.id.textViewConfirmPasswordSave).visibility == TextView.INVISIBLE
                && nicknameSave.isNotEmpty() && emailSave.isNotEmpty() && passSave.isNotEmpty() && confPassSave.isNotEmpty()
            ) {
                fbAuth.createUserWithEmailAndPassword(emailSave, passSave)
                    .addOnSuccessListener {authRes ->
                        if(authRes.user != null) {
                            val user = pl.putala.speedwayo1.data.User(
                                authRes.user!!.uid,
                                nicknameSave,
                                emailSave,
                                "",
                                "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                                "0",
                                "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
                                ArrayList<Date> ())
                            regVm.createNewUser(user)
                            startApp()
                        }
                    }
                    .addOnFailureListener {exc ->
                        Toast.makeText(this, "Ops... something went wrong!", Toast.LENGTH_SHORT).show()
                        Log.d(REG_DEBUG, exc.message.toString())
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
            }
        } else {
            findViewById<TextView>(R.id.textViewRegulations).visibility = TextView.VISIBLE
        }
    }


    fun cancel(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

}