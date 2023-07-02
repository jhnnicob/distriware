package com.wkt.distriware.domain.usecase.setting

import com.wkt.distriware.data.repository.ConfigSettingRepository
import com.wkt.distriware.data.repository.impl.ConfigSettingRepositoryImpl

class IsConfigSettingValidUseCase {
    private val configSetting: ConfigSettingRepository = ConfigSettingRepositoryImpl()
    operator fun invoke(): Boolean {
        return configSetting.isConfigSettingValid()
    }
}