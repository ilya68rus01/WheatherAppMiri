package khrushchev.ilya.wheatherapp.di.modules

import dagger.Module
import dagger.Provides
import khrushchev.ilya.wheatherapp.repository.WheatherService
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun providesWeatherService(retrofit: Retrofit): WheatherService =
        retrofit.create(WheatherService::class.java)

    @Provides
    fun providesWheatherRepository(service: WheatherService): RemoteWeatherRepository =
        RemoteWeatherRepositoryImpl(service)
}