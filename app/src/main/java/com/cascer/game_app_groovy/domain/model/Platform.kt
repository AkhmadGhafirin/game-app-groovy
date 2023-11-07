package com.cascer.game_app_groovy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Platform(
    val gamesCount: Int,
    val id: Int,
    val image: String,
    val imageBackground: String,
    val name: String,
    val slug: String,
    val yearEnd: Int,
    val yearStart: Int
) : Parcelable