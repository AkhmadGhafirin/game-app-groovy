package com.cascer.game_app_groovy.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChildPlatform(
    val platform: Platform,
    val releasedAt: String,
    val requirementsEn: Requirements,
) : Parcelable