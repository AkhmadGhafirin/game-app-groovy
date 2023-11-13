package com.cascer.game_app_groovy.core.data.local

import com.cascer.game_app_groovy.core.data.local.entity.GameEntity
import com.cascer.game_app_groovy.core.data.local.room.GameDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val gameDao: GameDao) {

    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllGame()

    fun insertGames(data: List<GameEntity>) = gameDao.insertGames(data)

    fun getFavoriteGames(): Flow<List<GameEntity>> = gameDao.getFavoriteGames()

    fun setFavoriteGame(game: GameEntity, newState: Boolean) {
        game.isFavorite = newState
        gameDao.updateFavoriteGame(game)
    }
}