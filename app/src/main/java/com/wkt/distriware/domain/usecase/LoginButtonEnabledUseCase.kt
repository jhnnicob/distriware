package com.wkt.distriware.domain.usecase

class LoginButtonEnabledUseCase {
    operator fun invoke(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }
}