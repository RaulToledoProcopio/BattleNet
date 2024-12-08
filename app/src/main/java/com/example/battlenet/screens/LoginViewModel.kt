package com.example.battlenet.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    private val _loginResult = MutableLiveData<Boolean?>()  // Cambié a Boolean?
    val loginResult: LiveData<Boolean?> get() = _loginResult  // Cambié a Boolean?

    private val validUsers = mapOf(
        "raul@gmail.com" to "12345",
        "raul@gmail.es" to "12345",
    )

    // Establece el email cuando se escribe
    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    // Establece la contraseña cuando se escribe
    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    // Validar el login
    fun validateLogin() {
        val email = _email.value ?: ""
        val password = _password.value ?: ""

        if (validUsers.contains(email) && validUsers[email] == password) {
            _loginResult.value = true
        } else {
            _loginResult.value = false
            _email.value = ""    // Borra el email
            _password.value = "" // Borra la contraseña
        }
    }
}