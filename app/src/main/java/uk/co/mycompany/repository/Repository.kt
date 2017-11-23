package uk.co.mycompany.repository

import io.reactivex.Single
import uk.co.mycompany.api.ApiService
import uk.co.mycompany.api.model.IpAddress
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

    fun getDataFromApi(): Single<IpAddress> = apiService.getJsonResponse()

}