package com.cascer.game_app_groovy.data.remote.response


import com.google.gson.annotations.SerializedName

data class ParentStoreResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("store")
    val store: StoreResponse?
)