package com.wkt.distriware.data.repository.impl

import com.wkt.distriware.data.dataStore.ConfigSettingDataStore
import com.wkt.distriware.data.repository.ConfigSettingRepository
import com.wkt.distriware.domain.model.ConfigSetting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ConfigSettingRepositoryImpl @Inject constructor(
    private val configSettingDataStore: ConfigSettingDataStore
): ConfigSettingRepository {

    override fun getConfigSetting(): Flow<ConfigSetting> {
        return configSettingDataStore.getConfigSetting()
    }

    override fun getConfigSetting(): ConfigSetting {
        return configSetting
    }

    override suspend fun isConfigSettingEmpty(): Flow<Boolean> {
        val configSettingFlow = configSettingDataStore.getConfigSetting()
        return configSettingFlow.map { configSetting ->
            val serverAddress = configSetting.serverAddress
            val port = configSetting.port
            serverAddress?.isEmpty() ?: false && port?.isEmpty() ?: false
        }
    }
}