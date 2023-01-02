package com.onex.ktapp.ui

import android.util.Log
import com.onex.ktapp.base.BaseViewModel
import com.onex.ktapp.base.handleRequest
import com.onex.ktapp.base.launch
import com.onex.ktapp.data.DataRepository

class LoginViewModel : BaseViewModel() {

    override fun start() {
//        TODO("Not yet implemented")
    }

    fun login(username: String, password: String, successCall: () -> Any? = {}) {
        launch({
            handleRequest(DataRepository.login(username, password),
                successBlock = {
                    Log.d("fuck", it.data.toString())
                    successCall.invoke()
                })
        })
    }

}