package com.cascer.game_app_groovy.detail

import androidx.lifecycle.ViewModel
import com.cascer.game_app_groovy.core.domain.model.Game
import com.cascer.game_app_groovy.core.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteGame(game: Game, newState: Boolean) {
        gameUseCase.setFavoriteGame(game, newState)
    }
}