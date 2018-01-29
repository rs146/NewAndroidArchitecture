package uk.co.mycompany.ui.main.di

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.*
import java.lang.annotation.Retention
import kotlin.annotation.AnnotationTarget.FUNCTION
import kotlin.reflect.KClass

/**
 * Created by Md. Sifat-Ul Haque on 1/29/2018.
 */

@Documented
@Target(FUNCTION)
@Retention(RetentionPolicy.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)