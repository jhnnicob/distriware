package com.wkt.distriware.ui.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wkt.distriware.domain.usecase.login.LoginButtonEnabledUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    val loginButtonEnabled = LoginButtonEnabledUseCase()

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _isLoginButtonEnabled = mutableStateOf(false)
    val isLoginButtonEnabled: Boolean by _isLoginButtonEnabled

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun setUsername(value: String) {
        _username.value = value
    }

    fun setPassword(value: String) {
        _password.value = value
    }

    fun updateLoginButtonEnabled() {
        _isLoginButtonEnabled.value = loginButtonEnabled(username.value, password.value)
    }

    fun login() {
        Log.d("SHOW_LOGIN_PROCESS", "${username.value}, ${password.value}")
        viewModelScope.launch {
            if (username.value != "admin" && password.value != "123") {
                _errorMessage.value = "Invalid username or password"

            }else {
                _isSuccess.value = true
            }
        }
    }

    fun resetErrorMessage() {
        viewModelScope.launch {
            _errorMessage.value = null
        }
    }
}