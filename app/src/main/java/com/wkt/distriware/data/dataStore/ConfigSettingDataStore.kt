package com.wkt.distriware.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.wkt.distriware.constant.Constant
import com.wkt.distriware.domain.model.ConfigSetting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "config_settings")

class ConfigSettingDataStore(private val context: Context) {

    private val serverAddressKey = stringPreferencesKey(Constant.SERVER_ADDRESS_TEXT)
    private val portNumberKey = stringPreferencesKey(Constant.PORT_NUMBER_TEXT)

    suspend fun saveConfigSetting(key: String, value: String) {
        val keyString = stringPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[keyString] = value
        }
    }

    fun getConfigSetting(): Flow<ConfigSetting> = context.dataStore.data
        .map { preferences ->
            ConfigSetting(
                serverAddress = preferences[serverAddressKey],
                port = preferences[portNumberKey],
            )
        }
}