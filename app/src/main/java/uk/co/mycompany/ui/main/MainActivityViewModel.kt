package uk.co.mycompany.ui.main

import android.arch.lifecycle.ViewModel
import io.reactivex.Single
import uk.co.mycompany.api.model.IpAddress
import uk.co.mycompany.repository.Repository
import uk.co.mycompany.util.SchedulerProvider
import javax.inject.Inject

open class MainActivityViewModel
@Inject constructor(private val repository: Repository, private val schedulerProvider: SchedulerProvider) :ViewModel(){

    fun showDataFromApi(): Single<IpAddress> = repository.getDataFromApi()
            .compose(schedulerProvider.getSchedulersForSingle())
}