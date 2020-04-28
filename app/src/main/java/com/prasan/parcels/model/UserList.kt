package com.prasan.parcels.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class UserList() {
    @SerializedName("items")
    @Expose
    private var items: List<User>? = null

     fun getItems(): List<User> {
        return items!!
    }

     fun setItems(items: List<User>) {
        this.items = items!!
    }
}