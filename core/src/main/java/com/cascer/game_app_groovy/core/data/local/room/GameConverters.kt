package com.cascer.game_app_groovy.core.data.local.room

import androidx.room.TypeConverter
import com.cascer.game_app_groovy.core.data.local.entity.EsrbRatingEntity
import com.cascer.game_app_groovy.core.data.local.entity.GenreEntity
import com.cascer.game_app_groovy.core.data.local.entity.ParentPlatformEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GameConverters {
    val gson = Gson()

    @TypeConverter
    fun parentPlatformListToString(data: List<ParentPlatformEntity>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToParentPlatformList(data: String): List<ParentPlatformEntity> {
        val objectType = object : TypeToken<List<ParentPlatformEntity>>() {}.type
        return gson.fromJson(data, objectType)
    }

    @TypeConverter
    fun genreListToString(data: List<GenreEntity>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToGenreList(data: String): List<GenreEntity> {
        val objectType = object : TypeToken<List<GenreEntity>>() {}.type
        return gson.fromJson(data, objectType)
    }


    @TypeConverter
    fun esrbRatingToString(data: EsrbRatingEntity): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToEsrbRating(data: String): EsrbRatingEntity {
        val objectType = object : TypeToken<EsrbRatingEntity>() {}.type
        return gson.fromJson(data, objectType)
    }
}