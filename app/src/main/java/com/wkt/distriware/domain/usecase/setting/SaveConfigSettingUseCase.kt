package com.wkt.distriware.domain.usecase.setting

import com.wkt.distriware.data.repository.ConfigSettingRepository

class SaveConfigSettingUseCase(
    private val configSettingRepository: ConfigSettingRepository
) {

    suspend operator fun invoke(key: String, value: String) {
        configSettingRepository.saveConfigSetting(key, value)
    }
}