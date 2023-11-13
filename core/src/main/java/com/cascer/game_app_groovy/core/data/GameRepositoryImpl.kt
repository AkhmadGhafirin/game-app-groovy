package com.cascer.game_app_groovy.core.data

import com.cascer.game_app_groovy.core.data.local.LocalDataSource
import com.cascer.game_app_groovy.core.data.remote.RemoteDataSource
import com.cascer.game_app_groovy.core.data.remote.network.ApiResponse
import com.cascer.game_app_groovy.core.data.remote.response.GameResponse
import com.cascer.game_app_groovy.core.domain.model.Game
import com.cascer.game_app_groovy.core.domain.repository.GameRepository
import com.cascer.game_app_groovy.core.utils.AppExecutors
import com.cascer.game_app_groovy.core.utils.DataMapper.toDomain
import com.cascer.game_app_groovy.core.utils.DataMapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : GameRepository {
    override fun getAllGame(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map { list -> list.map { it.toDomain() } }
            }

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val games = data.map { it.toEntity() }
                appExecutors.diskIO().execute { localDataSource.insertGames(games) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> =
                remoteDataSource.getAllGame()

            override fun shouldFetch(data: List<Game>?): Boolean = data.isNullOrEmpty()
        }.asFlow()

    override fun getFavoriteGames(): Flow<List<Game>> {
        return localDataSource.getFavoriteGames().map {
            it.map { game -> game.toDomain() }
        }
    }

    override fun setFavoriteGame(game: Game, newState: Boolean) {
        val entity = game.toEntity()
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(entity, newState) }
    }
}