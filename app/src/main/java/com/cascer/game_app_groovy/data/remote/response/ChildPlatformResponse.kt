package com.cascer.game_app_groovy.data.remote.response


import com.google.gson.annotations.SerializedName

data class ChildPlatformResponse(
    @SerializedName("platform")
    val platform: PlatformResponse?,
    @SerializedName("released_at")
    val releasedAt: String?,
    @SerializedName("requirements_en")
    val requirementsEn: RequirementsResponse?
)