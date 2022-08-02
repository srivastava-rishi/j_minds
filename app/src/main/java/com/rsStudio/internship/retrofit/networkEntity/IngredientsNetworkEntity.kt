package com.rsStudio.internship.retrofit.networkEntity

data class IngredientsNetworkEntity(
    val hops: List<HopNetworkEntity>,
    val malt: List<MaltNetworkEntity>,
    val yeast: String
)