package uk.co.mycompany.api

import io.reactivex.Single
import retrofit2.http.GET
import uk.co.mycompany.api.model.IpAddress

interface ApiService {

    @GET(".")
    fun getJsonResponse(): Single<IpAddress>
}