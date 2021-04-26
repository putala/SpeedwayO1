package pl.putala.speedwayo1

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pl.putala.speedwayo1.activites.ContestActivity

abstract class BaseActivity : AppCompatActivity() {



    fun validationPassword(password: EditText, passwordWarn: TextView) {
//    var goodPassword : Boolean = false
        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                if (password.isFocused && password.length() > 0 && password.length() < 5
                ) {
                    passwordWarn.visibility = TextView.VISIBLE
//                goodPassword = false
                } else {
                    passwordWarn.visibility = TextView.INVISIBLE
//                goodPassword = true
                }
            }
        })
//    return goodPassword
    }



    fun validationEmail(email: EditText, emailWarn: TextView) {

//    var goodEmail : Boolean = false

        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                if (email.isFocused && email.length() != 0
                ) {
                    var monkey = false
                    for (i in email.text) {
                        if (i == '@') {
                            monkey = true
                        }
                    }
                    if (monkey) {
                        emailWarn.visibility = TextView.INVISIBLE
//                    goodEmail = true
                    } else {
                        emailWarn.visibility = TextView.VISIBLE
//                    goodEmail = false
                    }
                } else {
                    emailWarn.visibility = TextView.INVISIBLE
//                goodEmail = true
                }
            }

        })
//    return goodEmail
    }





    protected fun startApp(){
        val intent = Intent(applicationContext, ContestActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

}