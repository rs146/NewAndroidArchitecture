package uk.co.mycompany.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

import uk.co.mycompany.R
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    @Inject lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel.doSomeWork()
    }
}
