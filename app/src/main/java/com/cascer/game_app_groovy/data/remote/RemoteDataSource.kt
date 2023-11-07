package com.cascer.game_app_groovy.data.remote

import android.util.Log
import com.cascer.game_app_groovy.BuildConfig
import com.cascer.game_app_groovy.data.remote.network.ApiResponse
import com.cascer.game_app_groovy.data.remote.network.ApiService
import com.cascer.game_app_groovy.data.remote.response.GameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllGame(): Flow<ApiResponse<List<GameResponse>>> {
        return flow {
            try {
                val response = apiService.getListGame(
                    key = BuildConfig.API_KEY, page = 1, pageSize = 10
                )
                val dataArray = response.results
                if (dataArray?.isNotEmpty() == true) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSourceError", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}