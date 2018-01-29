package uk.co.mycompany.ui.main.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uk.co.mycompany.ui.main.MainActivityViewModel
import uk.co.mycompany.ui.main.ViewModelFactory
import uk.co.mycompany.ui.main.ViewModelKey

/**
 * Created by Md. Sifat-Ul Haque on 1/29/2018.
 */
@Module
open abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindsMainViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}