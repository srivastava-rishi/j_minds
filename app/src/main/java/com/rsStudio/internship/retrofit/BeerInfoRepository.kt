package com.rsStudio.internship.retrofit

import javax.inject.Inject

class BeerInfoRepository

    @Inject
    constructor(private val api: BeerInfoApi) {

        suspend fun getBeerInfo() = api.getBeerDetails()

    }


