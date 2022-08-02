package com.rsStudio.internship.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cache")
data class CacheEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val abv: Double,
    val description: String,
    val image_url: String,
    val name: String,
    val tagline: String,
)
