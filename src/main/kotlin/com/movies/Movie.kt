package com.movies

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(name = "Movie", description = "Movie representation")
data class Movie(
    val id: Long,
    @Schema(required = true)
    var title: String
)
