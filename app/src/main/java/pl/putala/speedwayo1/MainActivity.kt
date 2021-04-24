package pl.putala.speedwayo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val buttonSingIn = findViewById<Button>(R.id.buttonSingIn)
        buttonRegister.setOnClickListener {
            buttonRegister.text = "Akcja!!!!";
            Toast.makeText(applicationContext, "Teraz się rejestrujesz.", Toast.LENGTH_SHORT).show()
        }
        buttonSingIn.setOnClickListener {
            buttonSingIn.text = "Kupa!!!!";
            Toast.makeText(applicationContext,"Teraz się logujesz.", Toast.LENGTH_SHORT).show()
        }



    }
}