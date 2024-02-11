package com.tvmaze.series

import com.tvmaze.episodes.Episodes

data class TvSerie(
    val averageRuntime: Int?,
    val ended: String?,
    val externals: Externals?,
    val genres: List<String>?,
    val id: Int?,
    val image: Image?,
    val language: String?,
    val name: String?,
    val network: Network,
    val officialSite: String?,
    val premiered: String?,
    val runtime: Int?,
    val schedule: Schedule?,
    val status: String?,
    val summary: String?,
    val type: String?,
    val updated: Int?,
    val url: String?,
    val webChannel: Any?,
    val weight: Int?,
    var episodes: Episodes?
) {
    data class Externals(
        val imdb: String,
        val thetvdb: Int,
        val tvrage: Int
    )

    data class Image(
        val medium: String,
        val original: String
    )

    data class Network(
        val country: Country,
        val id: Int,
        val name: String,
        val officialSite: String
    ) {
        data class Country(
            val code: String,
            val name: String,
            val timezone: String
        )
    }

    data class Schedule(
        val days: List<String>,
        val time: String
    )
}