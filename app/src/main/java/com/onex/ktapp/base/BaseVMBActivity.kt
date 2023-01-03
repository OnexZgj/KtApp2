package com.onex.ktapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseVMBActivity<VM : BaseViewModel>(private val contentViewResId: Int) :
    AppCompatActivity() {

    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initContentView()
        createObserve()
        initView(savedInstanceState)
    }

    open fun createObserve(){
        mViewModel.apply {
            exception.observe(this@BaseVMBActivity){
                requestError(it.message)
//                is SocketTimeoutException -> ToastUtil.showShort(
//                this@BaseVMBActivity,
//                getString(R.string.request_time_out)
//                )
//                is ConnectException, is UnknownHostException -> ToastUtil.showShort(
//                this@BaseVMBActivity,
//                getString(R.string.network_error)
//                )
//                else -> ToastUtil.showShort(
//                this@BaseVMBActivity, it.message ?: getString(R.string.response_error)
//                )
            }
        }
    }


    /** View相关初始化 */
    abstract fun initView(savedInstanceState: Bundle?)


    private fun initContentView() {
        setContentView(contentViewResId)
    }

    private fun initViewModel() {
        val type: Class<VM> =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        mViewModel = ViewModelProvider(this).get(type)
        mViewModel.start()
    }

    /** 提供一个请求错误的方法,用于像关闭加载框,显示错误布局之类的 */
    open fun requestError(msg: String?) {
        hideLoading()
    }

    abstract fun hideLoading()


}