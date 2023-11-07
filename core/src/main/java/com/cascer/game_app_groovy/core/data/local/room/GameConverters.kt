package com.cascer.game_app_groovy.core.data.local.room

import androidx.room.TypeConverter
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
}