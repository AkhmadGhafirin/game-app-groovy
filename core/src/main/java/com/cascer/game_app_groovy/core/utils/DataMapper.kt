package com.cascer.game_app_groovy.core.utils

import com.cascer.game_app_groovy.core.data.local.entity.GameEntity
import com.cascer.game_app_groovy.core.data.local.entity.ParentPlatformEntity
import com.cascer.game_app_groovy.core.data.remote.response.GameResponse
import com.cascer.game_app_groovy.core.data.remote.response.ParentPlatformResponse
import com.cascer.game_app_groovy.core.domain.model.AddedByStatus
import com.cascer.game_app_groovy.core.domain.model.EsrbRating
import com.cascer.game_app_groovy.core.domain.model.Game
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
        updated = updated.orEmpty()
    )

    private fun ParentPlatformResponse.toEntity() = ParentPlatformEntity(
        id = platform?.id ?: 0,
        name = platform?.name.orEmpty(),
        slug = platform?.slug.orEmpty()
    )

    fun GameResponse.toDomain() = Game(
        added = added ?: 0,
        addedByStatus = AddedByStatus(0, 0, 0, 0, 0, 0),
        backgroundImage = backgroundImage.orEmpty(),
        dominantColor = dominantColor.orEmpty(),
        esrbRating = EsrbRating(0, "", ""),
        genres = listOf(),
        id = id ?: 0,
        metacritic = metacritic ?: 0,
        name = name.orEmpty(),
        parentPlatforms = parentPlatforms?.map { it.toDomain() } ?: listOf(),
        platforms = listOf(),
        playtime = playtime ?: 0,
        rating = rating ?: 0.0,
        ratingTop = ratingTop ?: 0,
        ratings = listOf(),
        ratingsCount = ratingsCount ?: 0,
        released = released.orEmpty(),
        reviewsCount = reviewsCount ?: 0,
        reviewsTextCount = reviewsTextCount ?: 0,
        saturatedColor = saturatedColor.orEmpty(),
        shortScreenshots = listOf(),
        slug = slug.orEmpty(),
        stores = listOf(),
        suggestionsCount = suggestionsCount ?: 0,
        tags = listOf(),
        tba = tba ?: false,
        updated = updated.orEmpty(),
        isFavorite = false
    )

    private fun ParentPlatformResponse.toDomain() = ParentPlatform(
        platform = Platform(
            id = platform?.id ?: 0,
            name = platform?.name.orEmpty(),
            slug = platform?.slug.orEmpty(),
            image = platform?.image.orEmpty(),
            imageBackground = platform?.imageBackground.orEmpty(),
            yearStart = platform?.yearStart ?: 0,
            yearEnd = platform?.yearEnd ?: 0,
            gamesCount = platform?.gamesCount ?: 0
        )
    )

    fun GameEntity.toDomain() = Game(
        added = added,
        addedByStatus = AddedByStatus(0, 0, 0, 0, 0, 0),
        backgroundImage = backgroundImage,
        dominantColor = dominantColor,
        esrbRating = EsrbRating(0, "", ""),
        genres = listOf(),
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
        updated = updated
    )

    private fun ParentPlatform.toEntity() = ParentPlatformEntity(
        id = platform.id,
        name = platform.name,
        slug = platform.slug
    )
}