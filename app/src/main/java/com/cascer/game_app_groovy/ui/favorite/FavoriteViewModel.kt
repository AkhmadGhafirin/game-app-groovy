package com.cascer.game_app_groovy.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cascer.game_app_groovy.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(gameUseCase: GameUseCase) : ViewModel() {
    val favoriteGames = gameUseCase.getFavoriteGames().asLiveData()
}