package com.onex.ktapp.base

import com.onex.ktapp.bean.HttpResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository {
    suspend fun <T> apiCall(api: suspend () -> HttpResult<T>): HttpResult<T> {
        return withContext(Dispatchers.IO) {
            api.invoke()
        }
    }
}