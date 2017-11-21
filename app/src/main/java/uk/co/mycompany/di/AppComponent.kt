package uk.co.mycompany.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import uk.co.mycompany.AndroidApp
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: AndroidApp)
}