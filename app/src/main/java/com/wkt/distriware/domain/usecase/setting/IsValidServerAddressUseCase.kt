package com.wkt.distriware.domain.usecase.setting

class IsValidServerAddressUseCase {
    operator fun invoke(serverAddress: String): Boolean {
        val ipRegex = """^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$""".toRegex()
        return serverAddress.matches(ipRegex)
    }
}