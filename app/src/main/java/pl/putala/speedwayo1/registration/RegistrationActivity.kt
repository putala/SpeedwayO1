package pl.putala.speedwayo1.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import pl.putala.speedwayo1.BaseActivity
import pl.putala.speedwayo1.login.LoginActivity
import pl.putala.speedwayo1.R


class RegistrationActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        validationEmail(findViewById(R.id.editTextEmail), findViewById(R.id.textViewEmail))
        validationPassword(findViewById(R.id.editTextPassword), findViewById(R.id.textViewPassword))
    }




    fun save(view: View) {
        if(!findViewById<CheckBox>(R.id.checkBoxRegulations).isChecked){
            Toast.makeText(applicationContext, "Accept the regulations!", Toast.LENGTH_SHORT).show()
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    fun cancel(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

}