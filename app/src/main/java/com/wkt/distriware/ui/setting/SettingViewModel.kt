package com.wkt.distriware.ui.setting

import androidx.lifecycle.ViewModel
import com.wkt.distriware.domain.usecase.setting.GetConfigSettingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingViewModel: ViewModel() {

    private val getConfigSettingUseCase = GetConfigSettingUseCase()

    private val _serverAddress = MutableStateFlow<String?>(null)
    val serverAddress: StateFlow<String?> = _serverAddress

    private val _port = MutableStateFlow<String?>(null)
    val port: StateFlow<String?> = _port

    init {
        getConfigSetting()
    }

    private fun getConfigSetting() {
        val configSetting = getConfigSettingUseCase()
        _serverAddress.value = configSetting.serverAddress ?: "000.000.000.000"
        _port.value = configSetting.port ?: "000"
    }
}