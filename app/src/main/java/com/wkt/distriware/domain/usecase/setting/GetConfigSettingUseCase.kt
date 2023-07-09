package com.wkt.distriware.domain.usecase.setting

import com.wkt.distriware.data.repository.ConfigSettingRepository
import kotlinx.coroutines.flow.Flow

data class GetConfigSettingUseCase (
    private val configSetting: ConfigSettingRepository
) {

    operator fun invoke(key: String): Flow<String> {
        return configSetting.getDataStore(key)
    }
}