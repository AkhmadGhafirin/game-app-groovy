package com.cascer.game_app_groovy.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "added")
    val added: Int,
    @ColumnInfo(name = "backgroundImage")
    val backgroundImage: String,
    @ColumnInfo(name = "dominantColor")
    val dominantColor: String,
    @ColumnInfo(name = "metacritic")
    val metacritic: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "playtime")
    val playtime: Int,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "ratingTop")
    val ratingTop: Int,
    @ColumnInfo(name = "ratingsCount")
    val ratingsCount: Int,
    @ColumnInfo(name = "released")
    val released: String,
    @ColumnInfo(name = "reviewsCount")
    val reviewsCount: Int,
    @ColumnInfo(name = "reviewsTextCount")
    val reviewsTextCount: Int,
    @ColumnInfo(name = "saturatedColor")
    val saturatedColor: String,
    @ColumnInfo(name = "slug")
    val slug: String,
    @ColumnInfo(name = "suggestionsCount")
    val suggestionsCount: Int,
    @ColumnInfo(name = "tba")
    val tba: Boolean,
    @ColumnInfo(name = "updated")
    val updated: String,
    @ColumnInfo(name = "esrbRating")
    val esrbRating: EsrbRatingEntity,
    @ColumnInfo(name = "parentPlatforms")
    val parentPlatforms: List<ParentPlatformEntity>,
    @ColumnInfo(name = "genres")
    val genres: List<GenreEntity>,
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)