package pl.putala.speedwayo1.home

import androidx.lifecycle.ViewModel
import pl.putala.speedwayo1.repository.FirebaseRepository

class HomeViewModel : ViewModel() {

    private val repository = FirebaseRepository()
//    val cars = repository.getHomeVm()
    val cars = repository.getCars()

}