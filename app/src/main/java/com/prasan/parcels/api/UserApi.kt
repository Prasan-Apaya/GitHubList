package com.prasan.parcels.api

import com.prasan.parcels.model.UserList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("/search/users")
    fun getUsers(@Query("q") filter:String):Call<UserList>
}