package com.onex.ktapp.base

import android.provider.BaseColumns
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.onex.ktapp.bean.HttpResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun BaseViewModel.launch(
    tryBlock: suspend CoroutineScope.() -> Unit,
    catchBlock: suspend CoroutineScope.() -> Unit = {},
    finallyBlock: suspend CoroutineScope.() -> Unit = {}
) {
    viewModelScope.launch {
        try {
            tryBlock()
        } catch (e: Exception) {
            Log.e("fuck",e.message.toString())
            catchBlock()
        } finally {
            finallyBlock()
        }
    }
}

suspend fun <T> BaseViewModel.handleRequest(
    response: HttpResult<T>,
    successBlock: suspend CoroutineScope.(response: HttpResult<T>) -> Unit = {},
    errorBlock: suspend CoroutineScope.(response: HttpResult<T>) -> Boolean = { false }
) {
    coroutineScope {
        when (response.errorCode) {
            0 -> successBlock(response) // 服务器返回请求成功码
            else -> { // 服务器返回的其他错误码
                if (!errorBlock(response)) {
                    // 只有errorBlock返回false不拦截处理时，才去统一提醒错误提示
                    errorResponse.value = response
                }
            }
        }
    }
}