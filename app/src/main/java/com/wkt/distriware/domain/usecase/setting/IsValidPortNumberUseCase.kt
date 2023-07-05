package com.wkt.distriware.domain.usecase.setting

class IsValidPortNumberUseCase {
    operator fun invoke(portNumber: Int): Boolean {
        return portNumber in 0..65535
    }
}