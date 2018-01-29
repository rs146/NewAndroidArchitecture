package uk.co.mycompany.ui.main

import android.arch.lifecycle.ViewModel

import dagger.MapKey
import kotlin.annotation.Retention
import kotlin.reflect.KClass

/**
 * Created by Md. Sifat-Ul Haque on 1/29/2018.
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)