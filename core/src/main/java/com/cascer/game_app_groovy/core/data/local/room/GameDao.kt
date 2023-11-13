package com.cascer.game_app_groovy.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cascer.game_app_groovy.core.data.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM game")
    fun getAllGame(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGames(data: List<GameEntity>)

    @Query("SELECT * FROM game WHERE isFavorite = 1")
    fun getFavoriteGames(): Flow<List<GameEntity>>

    @Update
    fun updateFavoriteGame(game: GameEntity)
}