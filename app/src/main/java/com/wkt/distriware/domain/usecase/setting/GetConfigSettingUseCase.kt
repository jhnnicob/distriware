package com.wkt.distriware.domain.usecase.setting

import com.wkt.distriware.data.repository.ConfigSettingRepository
import com.wkt.distriware.domain.model.ConfigSetting
import kotlinx.coroutines.flow.Flow

data class GetConfigSettingUseCase (
    private val configSetting: ConfigSettingRepository
) {

    operator fun invoke(): Flow<ConfigSetting> {
        return configSetting.getConfigSetting()
    }
}