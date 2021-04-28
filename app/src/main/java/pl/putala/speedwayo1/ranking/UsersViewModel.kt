package pl.putala.speedwayo1.ranking

import androidx.lifecycle.ViewModel
import pl.putala.speedwayo1.repository.FirebaseRepository

class UsersViewModel : ViewModel() {

    private val repository = FirebaseRepository()
    val users = repository.getUsers()
}