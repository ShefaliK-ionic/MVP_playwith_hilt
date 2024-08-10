package com.mvparchitecture.presenter

import com.mvparchitecture.network.ApiInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserPresenter @Inject constructor(private val userContractView: UserContract.View
,private val apiInterface: ApiInterface) : UserContract.Presenter {


    var page=0
    var limit=30
    var skip=-30

    override fun getUsers() {
        val data = HashMap<String,Int>()
        page=page+10
        skip=skip+30
        data.put("page",page)
        data.put("limit",limit)
        data.put("skip",skip)
        userContractView.onLoading()

        CoroutineScope(Dispatchers.IO).launch {
 try {
     val myUser = apiInterface.getUser(data)
     userContractView.getUserData(myUser)
 }catch (e:Exception){
     userContractView.showError(e.toString())
 }
        }

    }
}