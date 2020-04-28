package com.prasan.parcels.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prasan.parcels.R
import com.prasan.parcels.model.User
import com.prasan.parcels.view.ui.UserDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_list.view.*

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList: List<User>?=null

    fun setUsers(users:List<User>) {
        this.userList = users
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user_list, parent, false)
        return UserViewHolder(v)
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindItems(userList!![position])
        holder.itemView.setOnClickListener { v ->
            val context: Context = v!!.context
            val intent = Intent(context, UserDetailActivity::class.java)
            val user:User = userList!![position]
            intent.putExtra("user",user)
            context.startActivity(intent)
        }
    }


    inner class UserViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bindItems(user:User) = with(view){
            username.text = user.login
            user_url.text = user.htmlUrl
            Picasso.get().load(user.avatarUrl).into(imageview_avatar)
        }
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }
}