package com.wkt.distriware.domain.usecase.setting

import com.wkt.distriware.data.repository.ConfigSettingRepository
import kotlinx.coroutines.flow.Flow

class ValidateConfigSettingEmptyUseCase(
    private val configSettingRepository: ConfigSettingRepository
) {
    suspend fun invoke(): Flow<Boolean> {
        return configSettingRepository.isConfigSettingEmpty()
    }
}