package com.wkt.distriware.data.repository.impl

import com.wkt.distriware.data.repository.ConfigSettingRepository
import com.wkt.distriware.domain.model.ConfigSetting

class ConfigSettingRepositoryImpl: ConfigSettingRepository {

    private val configSetting = ConfigSetting(
        serverAddress = "192.168.1.12",
        port = "8080"
    )

    override fun getConfigSetting(): ConfigSetting {
        return configSetting
    }

    override fun isConfigSettingEmpty(): Boolean {
        val serverAddress = configSetting.serverAddress ?: ""
        val port = configSetting.port ?: ""
        return serverAddress.isEmpty() && port.isEmpty()
    }

    override fun isConfigSettingValid(): Boolean {
        val serverAddress = configSetting.serverAddress ?: ""
        val port = configSetting.port ?: ""
        return serverAddress == "192.168.17.12" && port == "8080"
    }
}