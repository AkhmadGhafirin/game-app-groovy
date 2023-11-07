package com.cascer.game_app_groovy.data.remote.response


import com.google.gson.annotations.SerializedName

data class ParentPlatformResponse(
    @SerializedName("platform")
    val platform: PlatformResponse?
)