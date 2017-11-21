package uk.co.mycompany.repository

import io.reactivex.Single
import uk.co.mycompany.api.ApiService
import uk.co.mycompany.api.model.IpAddress

class Repository constructor(private val apiService: ApiService) {

    fun getDataFromApi(): Single<IpAddress> = apiService.getJsonResponse()

}