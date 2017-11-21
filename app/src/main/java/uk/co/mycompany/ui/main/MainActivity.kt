package uk.co.mycompany.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

import uk.co.mycompany.R
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    @Inject lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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
        compositeDisposable.clear()
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
