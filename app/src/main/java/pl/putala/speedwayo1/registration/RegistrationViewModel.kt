package pl.putala.speedwayo1.registration

import androidx.lifecycle.ViewModel
import pl.putala.speedwayo1.data.User
import pl.putala.speedwayo1.repository.FirebaseRepository

class RegistrationViewModel : ViewModel() {

    private val repository = FirebaseRepository()

    fun createNewUser(user: User) {
        repository.createNewUser(user)
    }


}