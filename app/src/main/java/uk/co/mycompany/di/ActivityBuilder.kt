package uk.co.mycompany.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uk.co.mycompany.ui.main.MainActivity
import uk.co.mycompany.ui.main.di.MainActivityModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}