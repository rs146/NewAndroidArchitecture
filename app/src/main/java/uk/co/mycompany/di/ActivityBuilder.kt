package uk.co.mycompany.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uk.co.mycompany.ui.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}