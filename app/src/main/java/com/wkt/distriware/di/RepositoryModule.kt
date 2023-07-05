package com.wkt.distriware.di

import com.wkt.distriware.data.dataStore.ConfigSettingDataStore
import com.wkt.distriware.data.repository.ConfigSettingRepository
import com.wkt.distriware.data.repository.impl.ConfigSettingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideConfigSettingRepository(configSettingDataStore: ConfigSettingDataStore): ConfigSettingRepository =
        ConfigSettingRepositoryImpl(configSettingDataStore)
}