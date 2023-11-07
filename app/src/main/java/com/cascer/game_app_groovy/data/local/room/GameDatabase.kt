package com.cascer.game_app_groovy.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cascer.game_app_groovy.data.local.entity.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
@TypeConverters(GameConverters::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun dao(): GameDao

    companion object {
        @Volatile
        private var INSTANCE: GameDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): GameDatabase {
            if (INSTANCE == null) {
                synchronized(GameDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        GameDatabase::class.java, "game_database"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE as GameDatabase
        }
    }
}