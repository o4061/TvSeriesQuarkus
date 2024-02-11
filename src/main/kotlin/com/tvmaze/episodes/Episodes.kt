package com.tvmaze.episodes

class Episodes : ArrayList<Episodes.EpisodesItem>(){
    data class EpisodesItem(
        val airdate: String?,
        val airstamp: String?,
        val airtime: String?,
        val id: Int?,
        val image: Image?,
        val name: String?,
        val number: Int?,
        val runtime: Int?,
        val season: Int?,
        val summary: String?,
        val type: String?,
        val url: String?
    ) {
        data class Image(
            val medium: String,
            val original: String
        )
    }
}