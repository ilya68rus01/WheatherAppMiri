package khrushchev.ilya.wheatherapp.di.components

import dagger.Component
import khrushchev.ilya.wheatherapp.App
import khrushchev.ilya.wheatherapp.generalview.GeneralWheatherFragment
import khrushchev.ilya.wheatherapp.di.modules.AppModule
import khrushchev.ilya.wheatherapp.di.modules.ViewModelFactoryModule
import khrushchev.ilya.wheatherapp.di.modules.ViewModelModule
import khrushchev.ilya.wheatherapp.repository.RemoteWeatherRepository

@Component(
    modules = [
        AppModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun provideWheatherRepository(): RemoteWeatherRepository

    fun inject(fragment: GeneralWheatherFragment)

    class Builder {
        companion object {
            fun build(app: App) : AppComponent {
                return DaggerAppComponent.builder().build()
            }
        }
    }
}