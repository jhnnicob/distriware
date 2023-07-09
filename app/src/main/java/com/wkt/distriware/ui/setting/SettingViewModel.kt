package com.wkt.distriware.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wkt.distriware.constant.Constant.PORT_NUMBER_TEXT
import com.wkt.distriware.constant.Constant.SERVER_ADDRESS_TEXT
import com.wkt.distriware.domain.usecase.ConfigSettingInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
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
        val serverFlow = configSettingInteractor.getConfigSettingUseCase(SERVER_ADDRESS_TEXT)
        val portFlow = configSettingInteractor.getConfigSettingUseCase(PORT_NUMBER_TEXT)
        val combinedFlow: Flow<Pair<String?, String?>> = serverFlow.combine(portFlow) { server, port ->
            server to port
        }
        viewModelScope.launch {
            combinedFlow.collect { pair ->
                _serverAddress.value = pair.first
                _port.value =  pair.second
            }
        }
    }

    fun saveConfigSetting(key: String, value: String) {
        viewModelScope.launch {
            configSettingInteractor.saveConfigSettingUseCase(key, value)
        }
    }
}