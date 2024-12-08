package com.example.battlenet.Screens

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {

    /* Primero utilizamos MutableLiveData para que los datos puedan cambiar internamente y luego
    los exponemos con LiveData para que solo puedan leerse */

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    // Llamamos a este metodo cada vez que el email o la contraseña cambian
    fun onLoginChanged(email: String, password: String) {

        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)

    }

    // Comprobamos si el login es posible
    fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
}
