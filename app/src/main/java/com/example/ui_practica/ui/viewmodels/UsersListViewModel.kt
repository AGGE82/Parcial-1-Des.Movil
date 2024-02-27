package com.example.ui_practica.ui.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ui_practica.data.models.User0

class UsersListViewModel: ViewModel() {
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email
    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name
    private val _number = MutableLiveData<String>()
    val number : LiveData<String> = _number
    private val _isEnabled = MutableLiveData<Boolean>()
    val isEnabled : LiveData<Boolean> = _isEnabled
    private val _isEditing = MutableLiveData<Boolean>()
    val isEditing : LiveData<Boolean> = _isEditing

    fun onChange(email: String, name: String, number: String) {
        _email.value = email
        _name.value = name
        _number.value = number
    }

}