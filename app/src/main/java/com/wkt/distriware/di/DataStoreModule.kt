package com.wkt.distriware.di

import android.content.Context
import com.wkt.distriware.data.dataStore.ConfigSettingDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideConfigSettingDataStore(@ApplicationContext context: Context)  =
        ConfigSettingDataStore(context)
}