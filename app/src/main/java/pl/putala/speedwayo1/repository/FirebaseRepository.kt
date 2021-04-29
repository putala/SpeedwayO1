package pl.putala.speedwayo1.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.common.collect.Maps
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import pl.putala.speedwayo1.data.Admin
import pl.putala.speedwayo1.data.User

class FirebaseRepository {

    private val REPO_DEBUG = "REPO_DEBUG"
    private val storage = FirebaseStorage.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val cloud = FirebaseFirestore.getInstance()

    fun getUserData(): LiveData<User>{
        val cloudResult = MutableLiveData<User>()
        val uid = auth.currentUser?.uid
        cloud.collection("users")
            .document(uid!!)
            .get()
            .addOnSuccessListener {
                val user = it.toObject(User::class.java)
                cloudResult.postValue(user!!)
            }
            .addOnFailureListener {
                Log.d(REPO_DEBUG, it.message.toString())
            }
        return cloudResult
    }


    fun getAdmin(): LiveData<Admin> {
        val cloudResult = MutableLiveData<Admin>()
        val uid = "MWdCAVAsom5VtFlGpdiu"
        cloud.collection("admin")
            .document(uid!!)
            .get()
            .addOnSuccessListener {
                val admin = it.toObject(Admin::class.java)
                cloudResult.postValue(admin!!)
            }
            .addOnFailureListener {
                Log.d(REPO_DEBUG, it.message.toString())
            }
        return cloudResult
    }


    fun getUsers(): LiveData<List<User>>{
        val cloudResult = MutableLiveData<List<User>>()
        cloud.collection("users")
            .get()
            .addOnSuccessListener {
                val user = it.toObjects(User::class.java)
                cloudResult.postValue(user)
            }
            .addOnFailureListener {
                Log.d(REPO_DEBUG, it.message.toString())
            }
        return cloudResult
    }


    fun createNewUser(user: User) {
        cloud.collection("users")
            .document(user.uid!!)
            .set(user)
    }


    fun editProfileData(map: Map<String, String>) {
        cloud.collection("users")
            .document(auth.currentUser!!.uid)
            .update(map)
            .addOnSuccessListener {
                Log.d(REPO_DEBUG, "Zaktualizowano dane!")
            }
            .addOnFailureListener {
                Log.d(REPO_DEBUG, it.message.toString())
            }

    }


//
//    fun addUser(user: User) {
//        cloud.collection("users")
//            .document(auth.currentUser?.uid!!)
//            .update("name", FieldValue.arrayUnion(user.uid))
//            .addOnSuccessListener {
//                Log.d(REPO_DEBUG, "Dodano imie użytkownika")
//            }
//            .addOnFailureListener {
//                Log.d(REPO_DEBUG, it.message.toString())
//            }
//    }


}