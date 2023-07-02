package com.wkt.distriware.data.repository

import com.wkt.distriware.domain.model.ConfigSetting

/**
 * ## Interface for configuration setting
 *
 * The `ConfigSettingRepository` interface provides methods for accessing and managing configuration settings.
 *
 * ### Usage
 *
 * To use the `ConfigSettingRepository`, obtain an instance and call its methods as needed.
 *
 * ```kotlin
 * val repository = ConfigSettingRepositoryImpl()
 * val configSetting = repository.getConfigSetting()
 * val isEmpty = repository.isConfigSettingEmpty()
 * val isValid = repository.isConfigSettingValid()
 * ```
 *
 * ### Remarks
 *
 * - The `getConfigSetting` method returns the current configuration setting as a [ConfigSetting] object.
 * - The `isConfigSettingEmpty` method returns `true` if the configuration setting is empty; otherwise, it returns `false`.
 * - The `isConfigSettingValid` method checks if the configuration setting is valid and returns a Boolean value.
 */
interface ConfigSettingRepository {
    fun getConfigSetting(): ConfigSetting
    fun isConfigSettingEmpty(): Boolean
    fun isConfigSettingValid(): Boolean
}