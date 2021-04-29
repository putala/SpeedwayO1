package pl.putala.speedwayo1.home

import androidx.lifecycle.ViewModel
import pl.putala.speedwayo1.repository.FirebaseRepository

class ProfileViewModel : ViewModel() {

    private val repository = FirebaseRepository()
    val user = repository.getUserData()

    fun editProfileData(map: Map<String, String>){
        repository.editProfileData(map)
    }

    fun uploadUserPhoto(bytes: ByteArray){
        repository.uploadUserPhoto(bytes)
    }

}