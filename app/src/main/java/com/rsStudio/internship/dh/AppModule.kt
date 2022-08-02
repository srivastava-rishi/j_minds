package com.rsStudio.internship.dh

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.rsStudio.internship.app.App
import com.rsStudio.internship.constant.Constant
import com.rsStudio.internship.data.database.CacheDatabase
import com.rsStudio.internship.retrofit.BeerInfoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext applicationContext: Context): App {
        return applicationContext as App
    }

    @Provides
    @Singleton
    fun provideSavedCacheData(app: Application): CacheDatabase{
        return Room.databaseBuilder(app,CacheDatabase::class.java,"cache")
            .build()
    }

    @Provides
    @Singleton
    fun provideBeerInfoApi(): BeerInfoApi =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(BeerInfoApi::class.java)

}