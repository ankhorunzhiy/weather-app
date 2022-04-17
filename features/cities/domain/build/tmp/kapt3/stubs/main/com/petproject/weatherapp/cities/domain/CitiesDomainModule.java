package com.petproject.weatherapp.cities.domain;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u001a\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/petproject/weatherapp/cities/domain/CitiesDomainModule;", "", "()V", "provideRepository", "Lcom/petproject/weatherapp/cities/domain/CitiesRepository;", "provideUseCase", "Lcom/petproject/weatherapp/cities/domain/CitiesUseCase;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "repo", "domain"})
@dagger.Module()
public final class CitiesDomainModule {
    
    public CitiesDomainModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.petproject.weatherapp.cities.domain.CitiesRepository provideRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.petproject.weatherapp.cities.domain.CitiesUseCase provideUseCase(@org.jetbrains.annotations.NotNull()
    @com.petproject.weatherapp.common.dispatchers.IoDispatcher()
    kotlinx.coroutines.CoroutineDispatcher dispatcher, @org.jetbrains.annotations.NotNull()
    com.petproject.weatherapp.cities.domain.CitiesRepository repo) {
        return null;
    }
}