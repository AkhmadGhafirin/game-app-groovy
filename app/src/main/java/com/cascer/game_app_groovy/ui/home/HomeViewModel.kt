package com.cascer.game_app_groovy.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cascer.game_app_groovy.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    gameUseCase: GameUseCase
) : ViewModel() {
    val games = gameUseCase.getAllGame().asLiveData()
}