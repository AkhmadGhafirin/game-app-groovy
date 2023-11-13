package com.cascer.game_app_groovy.di

import com.cascer.game_app_groovy.core.domain.usecase.GameUseCase
import com.cascer.game_app_groovy.core.domain.usecase.GameUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideGameUseCase(gameUseCase: GameUseCaseImpl): GameUseCase
}