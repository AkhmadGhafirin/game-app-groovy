package com.cascer.game_app_groovy.core.data.remote.response


import com.google.gson.annotations.SerializedName

data class PlatformResponse(
    @SerializedName("games_count")
    val gamesCount: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("image_background")
    val imageBackground: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("year_end")
    val yearEnd: Int?,
    @SerializedName("year_start")
    val yearStart: Int?
)