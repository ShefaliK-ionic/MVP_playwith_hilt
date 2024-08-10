package com.mvparchitecture.di

import com.mvparchitecture.network.ApiInterface
import com.mvparchitecture.presenter.UserContract
import com.mvparchitecture.view.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl()="https://dummyjson.com/"

    @Provides
    @Singleton
    fun getRetrofitBuilder(baseUrl:String):ApiInterface=
        Retrofit.Builder().baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).build().create(ApiInterface::class.java)



}