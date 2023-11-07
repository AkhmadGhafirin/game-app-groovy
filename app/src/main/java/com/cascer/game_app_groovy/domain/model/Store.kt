package com.cascer.game_app_groovy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Store(
    val domain: String,
    val gamesCount: Int,
    val id: Int,
    val imageBackground: String,
    val name: String,
    val slug: String
) : Parcelable