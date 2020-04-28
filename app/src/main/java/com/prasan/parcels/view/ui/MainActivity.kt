package com.prasan.parcels.view.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prasan.parcels.R
import com.prasan.parcels.api.ApiFactory.userApi
import com.prasan.parcels.model.User
import com.prasan.parcels.model.UserList
import com.prasan.parcels.view.adapter.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview_user_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


        getGitHubList()
    }

    private fun getGitHubList() {
        val searchParams = "language:java"
        val userCall: Call<UserList> = userApi.getUsers(searchParams)

        userCall.enqueue(object :Callback<UserList>{
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                t.message
                Log.d("MainActivity",t.message)
                Toast.makeText(baseContext,
                    "${t.message}Request failed. Check your internet connection",
                    Toast.LENGTH_SHORT).show();
            }

            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful){
                    var userList: UserList? = response.body()
                    val userAdapter = UserAdapter()
                    userAdapter.setUsers(userList!!.getItems())
                    recyclerView.adapter = userAdapter
                }
            }
        })
    }
}
