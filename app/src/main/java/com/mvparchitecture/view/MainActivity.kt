package com.mvparchitecture.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.mvparchitecture.R
import com.mvparchitecture.presenter.UserContract
import com.mvparchitecture.presenter.UserPresenter
import com.pagertask.model.UsersResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
public class MainActivity : AppCompatActivity(),UserContract.View {

    @Inject
    lateinit var userPresenter:UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userPresenter.getUsers()
    }

    override fun onLoading() {
        Log.d("222","~~~Show loader~~~")
    }

    override fun showError(toString: String) {
        Log.d("222","~~~Show error~~~"+ toString)

    }

    override fun getUserData(usersResponse: UsersResponse) {
        Log.d("222","~~~Show data~~~"+Gson().toJson(usersResponse))

    }
}