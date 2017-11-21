package uk.co.mycompany.ui.main

import io.reactivex.Single
import uk.co.mycompany.api.model.IpAddress
import uk.co.mycompany.repository.Repository
import uk.co.mycompany.util.SchedulerProvider

class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApi(): Single<IpAddress> = repository.getDataFromApi()
            .compose(schedulerProvider.getSchedulersForSingle())
}