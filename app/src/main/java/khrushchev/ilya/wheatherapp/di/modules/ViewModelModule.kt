package khrushchev.ilya.wheatherapp.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import khrushchev.ilya.wheatherapp.generalview.GeneralViewModel
import khrushchev.ilya.wheatherapp.di.ViewModelKey
import androidx.lifecycle.ViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GeneralViewModel::class)
    abstract fun bindGeneralViewModel(model: GeneralViewModel): ViewModel

}