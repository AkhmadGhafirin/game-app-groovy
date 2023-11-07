package com.cascer.game_app_groovy.data.remote.response


import com.google.gson.annotations.SerializedName

data class RatingResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("percent")
    val percent: Double?,
    @SerializedName("title")
    val title: String?
)