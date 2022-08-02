package com.rsStudio.internship.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rsStudio.internship.data.dao.CacheDao
import com.rsStudio.internship.data.entity.CacheEntity

@Database(entities = [CacheEntity::class], version = 1)

abstract class CacheDatabase: RoomDatabase() {

   abstract fun savedCacheData(): CacheDao
}