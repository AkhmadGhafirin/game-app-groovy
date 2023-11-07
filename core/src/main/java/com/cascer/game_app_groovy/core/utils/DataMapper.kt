package com.cascer.game_app_groovy.core.utils

import com.cascer.game_app_groovy.core.data.local.entity.EsrbRatingEntity
import com.cascer.game_app_groovy.core.data.local.entity.GameEntity
import com.cascer.game_app_groovy.core.data.local.entity.GenreEntity
import com.cascer.game_app_groovy.core.data.local.entity.ParentPlatformEntity
import com.cascer.game_app_groovy.core.data.remote.response.EsrbRatingResponse
import com.cascer.game_app_groovy.core.data.remote.response.GameResponse
import com.cascer.game_app_groovy.core.data.remote.response.GenreResponse
import com.cascer.game_app_groovy.core.data.remote.response.ParentPlatformResponse
import com.cascer.game_app_groovy.core.domain.model.AddedByStatus
import com.cascer.game_app_groovy.core.domain.model.EsrbRating
import com.cascer.game_app_groovy.core.domain.model.Game
import com.cascer.game_app_groovy.core.domain.model.Genre
import com.cascer.game_app_groovy.core.domain.model.ParentPlatform
import com.cascer.game_app_groovy.core.domain.model.Platform

object DataMapper {
    fun GameResponse.toEntity() = GameEntity(
        added = added ?: 0,
        backgroundImage = backgroundImage.orEmpty(),
        dominantColor = dominantColor.orEmpty(),
        id = id ?: 0,
        metacritic = metacritic ?: 0,
        name = name.orEmpty(),
        parentPlatforms = parentPlatforms?.map { it.toEntity() } ?: listOf(),
        playtime = playtime ?: 0,
        rating = rating ?: 0.0,
        ratingTop = ratingTop ?: 0,
        ratingsCount = ratingsCount ?: 0,
        released = released.orEmpty(),
        reviewsCount = reviewsCount ?: 0,
        reviewsTextCount = reviewsTextCount ?: 0,
        saturatedColor = saturatedColor.orEmpty(),
        slug = slug.orEmpty(),
        suggestionsCount = suggestionsCount ?: 0,
        tba = tba ?: false,
        updated = updated.orEmpty(),
        esrbRating = esrbRating?.toEntity() ?: EsrbRatingEntity(0, "", ""),
        genres = genres?.map { it.toEntity() } ?: listOf()
    )

    private fun GenreResponse.toEntity() = GenreEntity(
        id = id ?: 0,
        name = name.orEmpty(),
        slug = slug.orEmpty(),
        gamesCount = gamesCount ?: 0,
        imageBackground = imageBackground.orEmpty()
    )

    private fun EsrbRatingResponse.toEntity() = EsrbRatingEntity(
        id = id ?: 0,
        name = name.orEmpty(),
        slug = slug.orEmpty()
    )

    private fun ParentPlatformResponse.toEntity() = ParentPlatformEntity(
        id = platform?.id ?: 0,
        name = platform?.name.orEmpty(),
        slug = platform?.slug.orEmpty()
    )

//    fun GameResponse.toDomain() = Game(
//        added = added ?: 0,
//        addedByStatus = AddedByStatus(0, 0, 0, 0, 0, 0),
//        backgroundImage = backgroundImage.orEmpty(),
//        dominantColor = dominantColor.orEmpty(),
//        esrbRating = EsrbRating(0, "", ""),
//        genres = genres.map { it.toDomain() },
//        id = id ?: 0,
//        metacritic = metacritic ?: 0,
//        name = name.orEmpty(),
//        parentPlatforms = parentPlatforms?.map { it.toDomain() } ?: listOf(),
//        platforms = listOf(),
//        playtime = playtime ?: 0,
//        rating = rating ?: 0.0,
//        ratingTop = ratingTop ?: 0,
//        ratings = listOf(),
//        ratingsCount = ratingsCount ?: 0,
//        released = released.orEmpty(),
//        reviewsCount = reviewsCount ?: 0,
//        reviewsTextCount = reviewsTextCount ?: 0,
//        saturatedColor = saturatedColor.orEmpty(),
//        shortScreenshots = listOf(),
//        slug = slug.orEmpty(),
//        stores = listOf(),
//        suggestionsCount = suggestionsCount ?: 0,
//        tags = listOf(),
//        tba = tba ?: false,
//        updated = updated.orEmpty(),
//        isFavorite = false
//    )
//
//    private fun GenreEntity.toDomain

//    private fun ParentPlatformResponse.toDomain() = ParentPlatform(
//        platform = Platform(
//            id = platform?.id ?: 0,
//            name = platform?.name.orEmpty(),
//            slug = platform?.slug.orEmpty(),
//            image = platform?.image.orEmpty(),
//            imageBackground = platform?.imageBackground.orEmpty(),
//            yearStart = platform?.yearStart ?: 0,
//            yearEnd = platform?.yearEnd ?: 0,
//            gamesCount = platform?.gamesCount ?: 0
//        )
//    )

    fun GameEntity.toDomain() = Game(
        added = added,
        addedByStatus = AddedByStatus(0, 0, 0, 0, 0, 0),
        backgroundImage = backgroundImage,
        dominantColor = dominantColor,
        esrbRating = EsrbRating(esrbRating.id, esrbRating.name, esrbRating.slug),
        genres = genres.map { it.toDomain() },
        id = id,
        metacritic = metacritic,
        name = name,
        parentPlatforms = parentPlatforms.map { it.toDomain() },
        platforms = listOf(),
        playtime = playtime,
        rating = rating,
        ratingTop = ratingTop,
        ratings = listOf(),
        ratingsCount = ratingsCount,
        released = released,
        reviewsCount = reviewsCount,
        reviewsTextCount = reviewsTextCount,
        saturatedColor = saturatedColor,
        shortScreenshots = listOf(),
        slug = slug,
        stores = listOf(),
        suggestionsCount = suggestionsCount,
        tags = listOf(),
        tba = tba,
        updated = updated,
        isFavorite = isFavorite
    )

    private fun GenreEntity.toDomain() = Genre(
        gamesCount = gamesCount,
        id = id,
        imageBackground = imageBackground,
        name = name,
        slug = slug,
    )

    private fun ParentPlatformEntity.toDomain() = ParentPlatform(
        platform = Platform(
            gamesCount = 0,
            id = id,
            image = "",
            imageBackground = "",
            name = name,
            slug = slug,
            yearEnd = 0,
            yearStart = 0
        )
    )

    fun Game.toEntity() = GameEntity(
        added = added,
        backgroundImage = backgroundImage,
        dominantColor = dominantColor,
        id = id,
        metacritic = metacritic,
        name = name,
        parentPlatforms = parentPlatforms.map { it.toEntity() },
        playtime = playtime,
        rating = rating,
        ratingTop = ratingTop,
        ratingsCount = ratingsCount,
        released = released,
        reviewsCount = reviewsCount,
        reviewsTextCount = reviewsTextCount,
        saturatedColor = saturatedColor,
        slug = slug,
        suggestionsCount = suggestionsCount,
        tba = tba,
        updated = updated,
        esrbRating = esrbRating.toEntity(),
        genres = genres.map { it.toEntity() }
    )

    private fun EsrbRating.toEntity() = EsrbRatingEntity(
        id = id,
        name = name,
        slug = slug
    )

    private fun Genre.toEntity() = GenreEntity(
        id = id,
        name = name,
        slug = slug,
        gamesCount = gamesCount,
        imageBackground = imageBackground
    )

    private fun ParentPlatform.toEntity() = ParentPlatformEntity(
        id = platform.id,
        name = platform.name,
        slug = platform.slug
    )
}