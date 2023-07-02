package com.wkt.distriware.domain.usecase.setting

import com.wkt.distriware.data.repository.ConfigSettingRepository
import com.wkt.distriware.data.repository.impl.ConfigSettingRepositoryImpl

class ValidateConfigSettingEmptyUseCase {
    private val configSetting: ConfigSettingRepository = ConfigSettingRepositoryImpl()
    fun invoke(): Boolean {
        return configSetting.isConfigSettingEmpty()
    }
}