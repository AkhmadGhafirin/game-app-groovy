package com.cascer.game_app_groovy.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListGameResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<GameResponse>?
)
