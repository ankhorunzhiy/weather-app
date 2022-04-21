package com.petproject.weatherapp.common.dispatchers.android

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
internal object DispatchersModule {

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @MainImmediateDispatcher
    @Provides
    fun providesMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate
}