package uk.co.mycompany.ui.main

import android.os.Bundle
import android.util.Log
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

import uk.co.mycompany.R
import javax.inject.Inject

class MainActivity: DaggerActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        compositeDisposable.add(mainActivityViewModel.showDataFromApi()
                .subscribeBy(onSuccess = {
                    Log.d("MainActivity", it.ip)
                }, onError = {
                    Log.d("MainActivity", it.message)
                }))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
