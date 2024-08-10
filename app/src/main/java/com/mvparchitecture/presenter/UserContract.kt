package com.mvparchitecture.presenter

import com.pagertask.model.UsersResponse

interface UserContract {

    interface View {
        fun onLoading()
        fun showError(toString: String)
        fun getUserData(usersResponse:UsersResponse)
    }

    interface Presenter{
        fun getUsers()
    }

}