package com.rsStudio.internship.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rsStudio.internship.data.entity.CacheEntity


@Dao
interface CacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCacheData(cacheEntity: List<CacheEntity>)

    @Query("SELECT * FROM cache")

    fun getAllSavedCache() : List<CacheEntity>

}