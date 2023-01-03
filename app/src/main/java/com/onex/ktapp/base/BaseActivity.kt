package com.onex.ktapp.base

abstract class BaseActivity<VM:BaseViewModel> (contentViewResId:Int): BaseVMBActivity<VM>(contentViewResId) {
    override fun createObserve() {
        super.createObserve()
        mViewModel.errorResponse.observe(this) {
            if (it?.errorCode == -1001) {
                // 需要登录，这里主要是针对收藏操作，不想每个地方都判断一下
                // 当然你也可以封装一个收藏的组件，在里面统一判断跳转
//                LoginActivity.launch(this)
            }
        }
    }
}