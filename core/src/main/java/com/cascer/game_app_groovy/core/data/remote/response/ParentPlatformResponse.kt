package com.cascer.game_app_groovy.core.data.remote.response


import com.google.gson.annotations.SerializedName

data class ParentPlatformResponse(
    @SerializedName("platform")
    val platform: PlatformResponse?
)