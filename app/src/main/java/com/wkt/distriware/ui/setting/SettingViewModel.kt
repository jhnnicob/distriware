package com.wkt.distriware.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wkt.distriware.domain.usecase.ConfigSettingInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val configSettingInteractor: ConfigSettingInteractor
): ViewModel() {

    private val _serverAddress = MutableStateFlow<String?>(null)
    val serverAddress: StateFlow<String?> = _serverAddress

    private val _port = MutableStateFlow<String?>(null)
    val port: StateFlow<String?> = _port

    init {
        getConfigSetting()
    }

    private fun getConfigSetting() {
        val configSetting = configSettingInteractor.getConfigSettingUseCase()
        viewModelScope.launch {
            configSetting.collect { config ->
                _serverAddress.value = config.serverAddress ?: "000.000.000.000"
                _port.value = config.port ?: "000"
            }
        }
    }

    fun saveConfigSetting(key: String, value: String) {
        viewModelScope.launch {
            configSettingInteractor.saveConfigSettingUseCase(key, value)
        }
    }
}