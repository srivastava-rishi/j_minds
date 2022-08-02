package com.rsStudio.internship.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface BeerInfoApi {

    @GET("beers?page=1&per_page=1")

    suspend fun getBeerDetails(): Response<List<BeerNetworkEntity>>

}