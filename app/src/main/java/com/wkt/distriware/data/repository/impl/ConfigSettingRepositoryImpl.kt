package com.wkt.distriware.data.repository.impl

import com.wkt.distriware.data.dataStore.ConfigSettingDataStore
import com.wkt.distriware.data.repository.ConfigSettingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConfigSettingRepositoryImpl @Inject constructor(
    private val configSettingDataStore: ConfigSettingDataStore
): ConfigSettingRepository {

    override fun <T> getDataStore(key: String): Flow<T> {
        return configSettingDataStore.getDataStore(key)
    }

    override suspend fun saveConfigSetting(key: String, value: String) {
        configSettingDataStore.saveDataStore(key, value)
    }
}