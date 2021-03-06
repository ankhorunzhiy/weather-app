package com.petproject.weatherapp.common.dispatchers.di

import com.petproject.weatherapp.common.dispatchers.DefaultDispatcher
import com.petproject.weatherapp.common.dispatchers.IoDispatcher
import com.petproject.weatherapp.common.dispatchers.MainDispatcher
import com.petproject.weatherapp.common.dispatchers.MainImmediateDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@InstallIn(SingletonComponent::class)
@Module
internal object DispatchersCoreModule {

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}