package com.onex.ktapp.api

import com.onex.ktapp.bean.HttpResult
import com.onex.ktapp.bean.LoginData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("user/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ):HttpResult<LoginData>
}
