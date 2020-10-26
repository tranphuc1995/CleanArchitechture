package com.tranphuc.data.remote.api

import com.haroldadmin.cnradapter.NetworkResponse
import com.tranphuc.data.remote.response.GetListUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("2.2/users")
    suspend fun getListUser(
        @Query("page") page: String,
        @Query("pagesize") pagesize: String,
        @Query("site") site: String
    ): NetworkResponse<GetListUserResponse, Unit>
}