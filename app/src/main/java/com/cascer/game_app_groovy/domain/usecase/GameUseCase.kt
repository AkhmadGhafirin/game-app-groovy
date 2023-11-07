package com.cascer.game_app_groovy.domain.usecase

import com.cascer.game_app_groovy.data.Resource
import com.cascer.game_app_groovy.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllGame(): Flow<Resource<List<Game>>>
    fun getFavoriteGames(): Flow<List<Game>>
    fun setFavoriteGame(game: Game, newState: Boolean)
}