package com.cascer.game_app_groovy.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cascer.game_app_groovy.core.domain.usecase.GameUseCase

class FavoriteViewModel(gameUseCase: GameUseCase) : ViewModel() {
    val favoriteGames = gameUseCase.getFavoriteGames().asLiveData()
}