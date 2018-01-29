package uk.co.mycompany.ui.main

import android.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*

import uk.co.mycompany.R
import javax.inject.Inject

class MainActivity: AppCompatActivity(), HasFragmentInjector {

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    private val compositeDisposable by lazy { CompositeDisposable() }

    lateinit var mainActivityViewModel: MainActivityViewModel
    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        compositeDisposable.add(mainActivityViewModel.showDataFromApi()
                .subscribeBy(onSuccess = {
                    Log.d("MainActivity", it.ip)
                    tv.text = it.ip
                }, onError = {
                    Log.d("MainActivity", it.message)
                    tv.text = it.message
                }))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
