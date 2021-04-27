package pl.putala.speedwayo1.profile

import androidx.lifecycle.ViewModel
import pl.putala.speedwayo1.repository.FirebaseRepository

class ProfileViewModel : ViewModel() {

    private val repository = FirebaseRepository()
    val user = repository.getUserData()

}