package com.wkt.distriware.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.wkt.distriware.constant.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "config_settings")

@Suppress("UNCHECKED_CAST")
class ConfigSettingDataStore(private val context: Context) {

    suspend fun <T> saveDataStore(key: String, value: T) {
        val keyString = stringPreferencesKey(key)
        val valueString = when (value) {
            is List<*> -> (value as List<*>).joinToString(",")
            else -> value.toString()
        }

        context.dataStore.edit { preferences ->
            preferences[keyString] = valueString
        }
    }

    fun <T> getDataStore(key: String): Flow<T> = context.dataStore.data
        .map { preferences ->
            val keyString = stringPreferencesKey(key)
            preferences[keyString] as T
        }
}