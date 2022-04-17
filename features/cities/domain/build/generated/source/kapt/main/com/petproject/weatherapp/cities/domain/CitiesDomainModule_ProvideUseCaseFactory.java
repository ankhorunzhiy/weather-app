package com.petproject.weatherapp.cities.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CitiesDomainModule_ProvideUseCaseFactory implements Factory<CitiesUseCase> {
  private final CitiesDomainModule module;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  private final Provider<CitiesRepository> repoProvider;

  public CitiesDomainModule_ProvideUseCaseFactory(CitiesDomainModule module,
      Provider<CoroutineDispatcher> dispatcherProvider, Provider<CitiesRepository> repoProvider) {
    this.module = module;
    this.dispatcherProvider = dispatcherProvider;
    this.repoProvider = repoProvider;
  }

  @Override
  public CitiesUseCase get() {
    return provideUseCase(module, dispatcherProvider.get(), repoProvider.get());
  }

  public static CitiesDomainModule_ProvideUseCaseFactory create(CitiesDomainModule module,
      Provider<CoroutineDispatcher> dispatcherProvider, Provider<CitiesRepository> repoProvider) {
    return new CitiesDomainModule_ProvideUseCaseFactory(module, dispatcherProvider, repoProvider);
  }

  public static CitiesUseCase provideUseCase(CitiesDomainModule instance,
      CoroutineDispatcher dispatcher, CitiesRepository repo) {
    return Preconditions.checkNotNullFromProvides(instance.provideUseCase(dispatcher, repo));
  }
}
