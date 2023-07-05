package com.wkt.distriware.domain.usecase

import com.wkt.distriware.domain.usecase.setting.GetConfigSettingUseCase
import com.wkt.distriware.domain.usecase.setting.SaveConfigSettingUseCase

data class ConfigSettingInteractor(
    val getConfigSettingUseCase: GetConfigSettingUseCase,
    val saveConfigSettingUseCase: SaveConfigSettingUseCase,
)