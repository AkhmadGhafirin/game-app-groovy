package com.cascer.game_app_groovy.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val added: Int,
    val addedByStatus: AddedByStatus,
    val backgroundImage: String,
    val dominantColor: String,
    val esrbRating: EsrbRating,
    val genres: List<Genre>,
    val id: Int,
    val metacritic: Int,
    val name: String,
    val parentPlatforms: List<ParentPlatform>,
    val platforms: List<ChildPlatform>,
    val playtime: Int,
    val rating: Double,
    val ratingTop: Int,
    val ratings: List<Rating>,
    val ratingsCount: Int,
    val released: String,
    val reviewsCount: Int,
    val reviewsTextCount: Int,
    val saturatedColor: String,
    val shortScreenshots: List<ShortScreenshot>,
    val slug: String,
    val stores: List<ParentStore>,
    val suggestionsCount: Int,
    val tags: List<Tag>,
    val tba: Boolean,
    val updated: String,
    val isFavorite: Boolean,
) : Parcelable