package pl.putala.speedwayo1.home

import androidx.lifecycle.ViewModel
import pl.putala.speedwayo1.repository.FirebaseRepository

class AdminViewModel : ViewModel() {

    private val repository = FirebaseRepository()
    val admin = repository.getAdminData()

}