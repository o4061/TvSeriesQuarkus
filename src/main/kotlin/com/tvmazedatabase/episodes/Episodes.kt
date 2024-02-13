package com.tvmazedatabase.episodes

import com.tvmaze.episodes.Episodes
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

class Episodes : ArrayList<Episodes.EpisodesItem>() {
    class EpisodesItem {
        val airdate: String = ""
        val airstamp: String = ""
        val airtime: String = ""
        val id: Int = 0
        val name: String = ""
        val number: Int = 0
        val runtime: Int = 0
        val season: Int = 0
        val summary: String = ""
        val type: String = ""
        val url: String = ""

        @Embedded
        val image: Image? = null
    }

    @Embeddable
    class Image {
        val medium: String = ""
        val original: String = ""
    }
}