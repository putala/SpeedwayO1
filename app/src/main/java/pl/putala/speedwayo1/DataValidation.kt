package pl.putala.speedwayo1

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView


fun validationPassword(password: EditText, passwordWarn: TextView) {

    password.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {

            if (password.isFocused && password.length() > 0 && password.length() < 5
            ) {
                passwordWarn.visibility = TextView.VISIBLE
            } else {
                passwordWarn.visibility = TextView.INVISIBLE
            }
        }
    })
}


fun validationEmail(email: EditText, emailWarn: TextView) {

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
                } else {
                    emailWarn.visibility = TextView.VISIBLE
                }
            } else {
                emailWarn.visibility = TextView.INVISIBLE
            }
        }

    })

}







