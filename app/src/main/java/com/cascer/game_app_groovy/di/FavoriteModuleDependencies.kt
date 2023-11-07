package com.cascer.game_app_groovy.di

import com.cascer.game_app_groovy.core.domain.usecase.GameUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun gameUseCase(): GameUseCase
}