package com.example.appmentalhealth.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class UserViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName
    private val _userEmail = MutableLiveData<String>()
    val userEmail: LiveData<String> = _userEmail
    private val _userNim = MutableLiveData<String>()
    val userNim: LiveData<String> = _userNim
    private val _userPhoneNumber = MutableLiveData<String>()
    val userPhoneNumber: LiveData<String> = _userPhoneNumber

    init {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        if (userId != null) {
            fetchUserDetails(userId)
        } else {
            _userName.value = "User not logged in"
            _userEmail.value = ""
            _userNim.value = ""
            _userPhoneNumber.value = ""
        }
    }

    private fun fetchUserDetails(userId: String) {
        FirebaseFirestore.getInstance().collection("user").document(userId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    _userName.value = document.getString("fullname")
                    _userEmail.value = document.getString("email")
                    _userNim.value = document.getString("nim")
                    _userPhoneNumber.value = document.getString("PhoneNumber")
                } else {
                    _userName.value = "No such user"
                    _userEmail.value = ""
                    _userNim.value = ""
                    _userPhoneNumber.value = ""
                }
            }
            .addOnFailureListener {
                _userName.value = "Error fetching user details"
                _userEmail.value = ""
                _userNim.value = ""
                _userPhoneNumber.value = ""
            }
    }
}
