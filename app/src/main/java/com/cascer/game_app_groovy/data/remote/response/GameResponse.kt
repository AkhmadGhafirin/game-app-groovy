package com.cascer.game_app_groovy.data.remote.response


import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("added")
    val added: Int?,
    @SerializedName("added_by_status")
    val addedByStatus: AddedByStatusResponse?,
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("dominant_color")
    val dominantColor: String?,
    @SerializedName("esrb_rating")
    val esrbRating: EsrbRatingResponse?,
    @SerializedName("genres")
    val genres: List<GenreResponse>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("metacritic")
    val metacritic: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("parent_platforms")
    val parentPlatforms: List<ParentPlatformResponse>?,
    @SerializedName("platforms")
    val platforms: List<ChildPlatformResponse>?,
    @SerializedName("playtime")
    val playtime: Int?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("rating_top")
    val ratingTop: Int?,
    @SerializedName("ratings")
    val ratings: List<RatingResponse>?,
    @SerializedName("ratings_count")
    val ratingsCount: Int?,
    @SerializedName("released")
    val released: String?,
    @SerializedName("reviews_count")
    val reviewsCount: Int?,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int?,
    @SerializedName("saturated_color")
    val saturatedColor: String?,
    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshotResponse>?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("stores")
    val stores: List<ParentStoreResponse>?,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int?,
    @SerializedName("tags")
    val tags: List<TagResponse>?,
    @SerializedName("tba")
    val tba: Boolean?,
    @SerializedName("updated")
    val updated: String?,
)