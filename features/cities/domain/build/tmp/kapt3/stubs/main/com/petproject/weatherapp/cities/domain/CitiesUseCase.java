package com.petproject.weatherapp.cities.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/petproject/weatherapp/cities/domain/CitiesUseCase;", "Lcom/google/samples/apps/iosched/shared/domain/UseCase;", "", "", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "citiesRepository", "Lcom/petproject/weatherapp/cities/domain/CitiesRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/petproject/weatherapp/cities/domain/CitiesRepository;)V", "execute", "parameters", "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain"})
public final class CitiesUseCase extends com.google.samples.apps.iosched.shared.domain.UseCase<kotlin.Unit, java.util.Collection<? extends java.lang.String>> {
    private final com.petproject.weatherapp.cities.domain.CitiesRepository citiesRepository = null;
    
    public CitiesUseCase(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher, @org.jetbrains.annotations.NotNull()
    com.petproject.weatherapp.cities.domain.CitiesRepository citiesRepository) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    kotlin.Unit parameters, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Collection<java.lang.String>> continuation) {
        return null;
    }
}