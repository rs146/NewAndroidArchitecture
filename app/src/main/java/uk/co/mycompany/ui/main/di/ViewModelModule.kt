package uk.co.mycompany.ui.main.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.multibindings.IntoMap
import uk.co.mycompany.ui.main.MainActivityViewModel
import uk.co.mycompany.ui.main.ViewModelFactory

/**
 * Created by Md. Sifat-Ul Haque on 1/29/2018.
 */
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindsMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    internal abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}