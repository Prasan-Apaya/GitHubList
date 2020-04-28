package com.prasan.parcels.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.prasan.parcels.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiFactory{

    private fun retrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.GIT_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


    val userApi : UserApi = retrofit().create(UserApi::class.java)
}