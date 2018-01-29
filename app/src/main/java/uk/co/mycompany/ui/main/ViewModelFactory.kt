package uk.co.mycompany.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Md. Sifat-Ul Haque on 1/29/2018.
 */
@Singleton
class ViewModelFactory @Inject
constructor(private val creators: Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    init {
        Log.d(TAG, "ViewModelFactory: ")
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass)
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

    companion object {
        private val TAG = "ViewModelFactory"
    }
}