package com.wkt.distriware.domain.usecase.login

class LoginButtonEnabledUseCase {
    operator fun invoke(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }
}