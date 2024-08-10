package com.mvparchitecture.network

import com.pagertask.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET("users")
    suspend fun getUser(@QueryMap queryMap: HashMap<String, Int>):UsersResponse

}