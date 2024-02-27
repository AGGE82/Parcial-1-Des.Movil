package com.example.ui_practica.ui.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ui_practica.data.models.User0

class NewUsersViewModel: ViewModel() {
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email
    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name
    private val _number = MutableLiveData<String>()
    val number : LiveData<String> = _number
    private val _isEnabled = MutableLiveData<Boolean>()
    val isEnabled : LiveData<Boolean> = _isEnabled
    private val _users = MutableLiveData<MutableList<User0>>()
    val users : LiveData<MutableList<User0>> = _users

    fun onChange(email: String, name: String, number: String) {
        _email.value = email
        _name.value = name
        _number.value = number
        _isEnabled.value = isValidEmail(email) && isValidNumber(number)
    }

    private fun isValidEmail(email:String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidNumber(number:String):Boolean{
        return number.length >= 8
    }

    fun addUser(nombre: String, email: String, number: String, userList: MutableList<User0>?){
        if (_isEnabled.value==true) {
            if (userList != null) {
                userList.add(User0(nombre, email, number))
                updateUsers(userList)
            }
        }
    }

    fun updateUsers(users: MutableList<User0>){
        _users.value = users
    }
}