package com.rsStudio.internship.dh

import android.content.Context
import com.google.gson.GsonBuilder
import com.rsStudio.internship.app.App
import com.rsStudio.internship.constant.Constant
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
    fun provideBeerInfoApi(): BeerInfoApi =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(BeerInfoApi::class.java)

}