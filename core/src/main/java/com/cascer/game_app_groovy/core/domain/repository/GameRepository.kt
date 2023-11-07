package com.cascer.game_app_groovy.core.domain.repository

import com.cascer.game_app_groovy.core.data.Resource
import com.cascer.game_app_groovy.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun getAllGame(): Flow<Resource<List<Game>>>
    fun getFavoriteGames(): Flow<List<Game>>
    fun setFavoriteGame(game: Game, newState: Boolean)
}