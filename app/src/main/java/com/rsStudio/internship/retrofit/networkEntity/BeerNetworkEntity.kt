package com.rsStudio.internship.retrofit.networkEntity

import java.io.Serializable

data class BeerNetworkEntity (
    val id: Int,
    val abv: Double,
    val description: String,
    val image_url: String,
    val name: String,
    val tagline: String,
) : Serializable