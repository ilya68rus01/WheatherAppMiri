package khrushchev.ilya.wheatherapp

import android.app.Application
import khrushchev.ilya.wheatherapp.di.components.AppComponent
import khrushchev.ilya.wheatherapp.di.components.AppComponent.Builder.Companion.build

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = build(this)
    }
}