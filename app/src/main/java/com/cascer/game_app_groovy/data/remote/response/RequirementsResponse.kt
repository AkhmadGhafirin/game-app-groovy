package com.cascer.game_app_groovy.data.remote.response


import com.google.gson.annotations.SerializedName

data class RequirementsResponse(
    @SerializedName("minimum")
    val minimum: String?,
    @SerializedName("recommended")
    val recommended: String?
)