package uk.co.mycompany.ui.main.di

import dagger.Module
import dagger.Provides
import uk.co.mycompany.ui.main.MainActivityViewModel

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel() = MainActivityViewModel()
}