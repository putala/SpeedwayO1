package pl.putala.speedwayo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import pl.putala.speedwayo1.activites.ContestActivity

abstract class BaseActivity : AppCompatActivity() {

    protected fun startApp(){
        val intent = Intent(applicationContext, ContestActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

}