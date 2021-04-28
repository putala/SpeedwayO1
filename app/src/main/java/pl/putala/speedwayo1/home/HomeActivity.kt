package pl.putala.speedwayo1.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import pl.putala.speedwayo1.R
import pl.putala.speedwayo1.contest.ContestAdapter
import pl.putala.speedwayo1.data.Car

class HomeActivity : AppCompatActivity() {

    // private val profileVm by viewModels<ProfileViewModel>()
    private val homeVm by viewModels<HomeViewModel>()
    private val adapter = CarAdapter(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)





        findViewById<RecyclerView>(R.id.recyclerViewCar).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerViewCar).adapter = adapter



        homeVm.cars.observe(this, Observer { list ->
            adapter.setCars(list)
            // CarAdapter(this).setCars(list)
        })



    }




    fun onCarLongClick(car: Car, position: Int) {
        Toast.makeText(this, car.name, Toast.LENGTH_SHORT).show()
    }


}
