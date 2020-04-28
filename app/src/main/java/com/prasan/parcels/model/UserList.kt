package com.prasan.parcels.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class UserList(@SerializedName("items")
                     @Expose
                     var items: List<User>)