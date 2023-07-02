package com.wkt.distriware.domain.usecase.setting

import com.wkt.distriware.data.repository.ConfigSettingRepository
import com.wkt.distriware.data.repository.impl.ConfigSettingRepositoryImpl
import com.wkt.distriware.domain.model.ConfigSetting

class GetConfigSettingUseCase {
    private val configSetting: ConfigSettingRepository = ConfigSettingRepositoryImpl()
    operator fun invoke(): ConfigSetting {
        return configSetting.getConfigSetting()
    }
}