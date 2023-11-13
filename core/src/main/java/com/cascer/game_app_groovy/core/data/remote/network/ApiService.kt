package com.cascer.game_app_groovy.core.data.remote.network

import com.cascer.game_app_groovy.core.data.remote.response.ListGameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getListGame(
        @Query("key") key: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): ListGameResponse
}