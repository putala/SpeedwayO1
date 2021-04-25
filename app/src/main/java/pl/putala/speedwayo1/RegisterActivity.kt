package pl.putala.speedwayo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


    }

    fun save(view: View) {
        if(!findViewById<CheckBox>(R.id.checkBoxRegulations).isChecked){
            Toast.makeText(applicationContext, "Accept the regulations!", Toast.LENGTH_SHORT).show()
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun cancel(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

}