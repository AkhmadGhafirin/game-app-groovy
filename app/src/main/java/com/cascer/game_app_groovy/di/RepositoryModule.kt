package com.cascer.game_app_groovy.di

import com.cascer.game_app_groovy.data.GameRepositoryImpl
import com.cascer.game_app_groovy.domain.repository.GameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideGameRepository(gameRepository: GameRepositoryImpl): GameRepository
}