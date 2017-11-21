package uk.co.mycompany.ui.main.di

import dagger.Module
import dagger.Provides
import uk.co.mycompany.repository.Repository
import uk.co.mycompany.ui.main.MainActivityViewModel
import uk.co.mycompany.util.SchedulerProvider

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: Repository, schedulerProvider: SchedulerProvider) = MainActivityViewModel(repository, schedulerProvider)
}