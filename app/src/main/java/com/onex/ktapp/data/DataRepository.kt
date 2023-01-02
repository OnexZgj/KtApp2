package com.onex.ktapp.data

import RetrofitHelper
import com.onex.ktapp.api.ApiService
import com.onex.ktapp.base.BaseRepository
import com.onex.ktapp.bean.HttpResult
import com.onex.ktapp.bean.LoginData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DataRepository : BaseRepository(), ApiService {

    private val service by lazy { RetrofitHelper.service }
    override suspend fun login(username: String, password: String): HttpResult<LoginData> {
        return withContext(Dispatchers.IO) {
            service.login(username, password)
        }
    }
}