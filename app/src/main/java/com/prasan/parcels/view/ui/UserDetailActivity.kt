package com.prasan.parcels.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prasan.parcels.R
import com.prasan.parcels.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val user: User = intent.getParcelableExtra("user")
        textview_user_detail_name.text = user.login
        textview_user_detail_url.text = user.htmlUrl
        Picasso.get().load(user.avatarUrl).into(imageview_user_detail_avatar);
    }
}