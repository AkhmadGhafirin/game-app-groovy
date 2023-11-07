package com.cascer.game_app_groovy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParentPlatform(
    val platform: Platform
) : Parcelable