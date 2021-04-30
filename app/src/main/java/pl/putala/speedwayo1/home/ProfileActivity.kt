package pl.putala.speedwayo1.home

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.data.User
import pl.putala.speedwayo1.ranking.UsersActivity
import pl.putala.speedwayo1.login.LoginActivity
import java.io.ByteArrayOutputStream

class ProfileActivity : AppCompatActivity() {

    private val profileVm by viewModels<ProfileViewModel>()
    private val PROFILE_DEBUG = "PROFILE_DEBUG"
    private val auth = FirebaseAuth.getInstance()
    private val REQUEST_CAPTURE_IMAGE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


//        val language = resources.getStringArray(R.array.language)
//        val spinner = findViewById<Spinner>(R.id.spinnerLanguage)
//        val spinerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, language)
//        spinner.adapter = spinerAdapter

        profileVm.user.observe(this, Observer { user -> bindUserData(user) })

    }


    fun createPhoto(view: View) {
        setupTakePictureClick()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == REQUEST_CAPTURE_IMAGE && requestCode == RESULT_OK){
            val image = data?.extras?.get("data") as Bitmap

            Glide.with(this)
                .load(image)
                .circleCrop()
                .into(findViewById<ImageView>(R.id.imageViewUserS))

            val stream = ByteArrayOutputStream()
            val result = image.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray = stream.toByteArray()

            if(result) profileVm.uploadUserPhoto(byteArray)
        }
    }

    private fun setupTakePictureClick() {
        findViewById<ImageView>(R.id.imageViewUserS).setOnClickListener {
            takePicture()
        }
    }

    private fun takePicture() {
        try {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_CAPTURE_IMAGE)
        } catch (exc: Exception) {
            Log.d(PROFILE_DEBUG, exc.message.toString())
        }
    }


    private fun bindUserData(user: User) {
        Log.d(PROFILE_DEBUG, user.toString())
        findViewById<TextView>(R.id.textViewNameS).text = user.name
        findViewById<TextView>(R.id.textViewEmailS).text = user.email
        findViewById<TextView>(R.id.textViewPointsSumS).text = user.sumOfPoints
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_contest -> {
                startActivity(Intent(this, ContestActivity::class.java))
            }
            R.id.action_ranking -> {
                startActivity(Intent(this, UsersActivity::class.java))
            }
            R.id.action_settings -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            R.id.action_logout -> {
                auth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }


}