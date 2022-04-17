package com.petproject.weatherapp.cities.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CitiesDomainModule_ProvideRepositoryFactory implements Factory<CitiesRepository> {
  private final CitiesDomainModule module;

  public CitiesDomainModule_ProvideRepositoryFactory(CitiesDomainModule module) {
    this.module = module;
  }

  @Override
  public CitiesRepository get() {
    return provideRepository(module);
  }

  public static CitiesDomainModule_ProvideRepositoryFactory create(CitiesDomainModule module) {
    return new CitiesDomainModule_ProvideRepositoryFactory(module);
  }

  public static CitiesRepository provideRepository(CitiesDomainModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideRepository());
  }
}
