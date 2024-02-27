package com.example.ui_practica.ui.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeScreenViewModel: ViewModel() {
    private val _isEnabled = MutableLiveData<Boolean>()
    val isEnabled : LiveData<Boolean> = _isEnabled

    fun onChange() {
        //_isEnabled.value = isUserListEmpty()
    }

    private fun isValidEmail(email:String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidNumber(number:String):Boolean{
        return number.length >= 8
    }
}