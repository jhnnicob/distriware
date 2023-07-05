package com.wkt.distriware.di

import com.wkt.distriware.data.repository.ConfigSettingRepository
import com.wkt.distriware.domain.usecase.ConfigSettingInteractor
import com.wkt.distriware.domain.usecase.setting.GetConfigSettingUseCase
import com.wkt.distriware.domain.usecase.setting.SaveConfigSettingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

    @Singleton
    @Provides
    fun provideConfigSettingInteractor(configSettingRepository: ConfigSettingRepository) =
        ConfigSettingInteractor(
            GetConfigSettingUseCase(configSettingRepository),
            SaveConfigSettingUseCase(configSettingRepository),
        )
}