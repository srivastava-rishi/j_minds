package com.rsStudio.internship.retrofit.networkEntity

data class MethodNetworkEntity(
    val fermentation: FermentationNetworkEntity,
    val mash_temp: List<MashTempNetworkEntity>,
    val twist: Any
)