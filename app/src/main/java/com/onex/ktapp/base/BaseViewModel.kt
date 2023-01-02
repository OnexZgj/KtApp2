package com.onex.ktapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onex.ktapp.bean.HttpResult

abstract class BaseViewModel : ViewModel() {
    /**
     * 界面启动时要进行初始化逻辑，如网络请求，数据初始化等
     */
    abstract fun start()
    /** 请求异常（服务器请求失败，譬如：服务器连接超时等） */
    val exception = MutableLiveData<Exception>()

    /** 请求服务器返回错误（服务器请求成功但status错误，譬如：登录过期等） */
    val errorResponse = MutableLiveData<HttpResult<*>?>()

}