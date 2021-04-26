package pl.putala.speedwayo1

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pl.putala.speedwayo1.activites.ContestActivity

abstract class BaseActivity : AppCompatActivity() {


    protected fun validationText(text: EditText, textWarn: TextView) {
        text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (text.isFocused && text.length() > 0 && text.length() < 5
                ) {
                    textWarn.visibility = TextView.VISIBLE
                } else {
                    textWarn.visibility = TextView.INVISIBLE
                }
            }
        })
    }


    protected fun validationPassword(
        password: EditText,
        confirmPassword: EditText,
        confirmWarn: TextView
    ) {
        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if ( password.length() > 0 && confirmPassword.length() > 0 && password.isFocused && confirmPassword.text.toString() != password.text.toString()) {
                    confirmWarn.visibility = TextView.VISIBLE
                } else {
                    confirmWarn.visibility = TextView.INVISIBLE
                }
            }
        })
        confirmPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if ( password.length() > 0 && confirmPassword.length() > 0 && confirmPassword.isFocused && confirmPassword.text.toString() != password.text.toString()) {
                    confirmWarn.visibility = TextView.VISIBLE
                } else {
                    confirmWarn.visibility = TextView.INVISIBLE
                }
            }
        })
    }


    protected fun validationEmail(email: EditText, emailWarn: TextView) {

        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                if (email.isFocused && email.length() != 0
                ) {
                    var first = false
                    var monkey = false
                    var dot = false
                    var end = false
                    for (i in email.text) {
                        if (dot && i != '@' && i != '.') {
                            end = true
                        }
                        if (monkey && i == '.'){
                            dot = true
                        }
                        if (first && i == '@') {
                            monkey = true
                        }
                        if (i != '@' && i != '.'){
                            first = true
                        }
                    }
                    if (end) {
                        emailWarn.visibility = TextView.INVISIBLE
                    } else {
                        emailWarn.visibility = TextView.VISIBLE
                    }
                } else {
                    emailWarn.visibility = TextView.INVISIBLE
                }
            }
        })
    }


    protected fun startApp() {
        val intent = Intent(applicationContext, ContestActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

}