package com.cascer.game_app_groovy.domain.usecase

import com.cascer.game_app_groovy.data.Resource
import com.cascer.game_app_groovy.domain.model.Game
import com.cascer.game_app_groovy.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameUseCaseImpl @Inject constructor(
    private val gameRepository: GameRepository
) : GameUseCase {

    override fun getAllGame(): Flow<Resource<List<Game>>> = gameRepository.getAllGame()

    override fun getFavoriteGames(): Flow<List<Game>> = gameRepository.getFavoriteGames()

    override fun setFavoriteGame(game: Game, newState: Boolean) =
        gameRepository.setFavoriteGame(game, newState)
}