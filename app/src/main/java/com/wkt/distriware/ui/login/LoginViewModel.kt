package com.wkt.distriware.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wkt.distriware.domain.usecase.LoginButtonEnabledUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel: ViewModel() {

    val loginButtonEnabled = LoginButtonEnabledUseCase()

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _isLoginButtonEnabled = mutableStateOf(false)
    val isLoginButtonEnabled: Boolean by _isLoginButtonEnabled

    fun setUsername(value: String) {
        _username.value = value
    }

    fun setPassword(value: String) {
        _password.value = value
    }

    fun updateLoginButtonEnabled() {
        _isLoginButtonEnabled.value = loginButtonEnabled(username.value, password.value)
    }
}