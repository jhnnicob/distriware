package com.wkt.distriware.data.repository

import com.wkt.distriware.domain.model.ConfigSetting

interface ConfigSettingRepository {
    fun getConfigSetting(): ConfigSetting
    fun isConfigSettingEmpty(): Boolean
    fun isConfigSettingValid(): Boolean
}