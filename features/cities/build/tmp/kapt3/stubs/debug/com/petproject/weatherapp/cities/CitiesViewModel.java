package com.petproject.weatherapp.cities;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/petproject/weatherapp/cities/CitiesViewModel;", "Landroidx/lifecycle/ViewModel;", "citiesUseCase", "Lcom/petproject/weatherapp/cities/domain/CitiesUseCase;", "(Lcom/petproject/weatherapp/cities/domain/CitiesUseCase;)V", "loadDataSignal", "Lkotlinx/coroutines/flow/Flow;", "", "refreshSignal", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/petproject/weatherapp/cities/CitiesUiModel;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "cities_debug"})
public final class CitiesViewModel extends androidx.lifecycle.ViewModel {
    private final com.petproject.weatherapp.cities.domain.CitiesUseCase citiesUseCase = null;
    private final kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> refreshSignal = null;
    private final kotlinx.coroutines.flow.Flow<kotlin.Unit> loadDataSignal = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.petproject.weatherapp.cities.CitiesUiModel> uiState = null;
    
    @javax.inject.Inject()
    public CitiesViewModel(@org.jetbrains.annotations.NotNull()
    com.petproject.weatherapp.cities.domain.CitiesUseCase citiesUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.petproject.weatherapp.cities.CitiesUiModel> getUiState() {
        return null;
    }
    
    public final void refresh() {
    }
}