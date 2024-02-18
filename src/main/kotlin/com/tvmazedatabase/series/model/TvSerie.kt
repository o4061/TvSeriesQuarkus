package com.tvmazedatabase.series.model

import com.tvmazedatabase.episodes.model.Episode
import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.*

@Entity
class TvSerie : PanacheEntityBase() {
    @Id
    var id: Int = 0
    var averageRuntime: Int = 0
    var ended: String? = ""
    var status: String = ""

    @Column(length = 2048)
    var summary: String = ""
    var type: String = ""
    var updated: Int = 0
    var url: String = ""
    var weight: Int = 0
    var language: String = ""
    var name: String = ""

    var officialSite: String? = ""
    var premiered: String = ""
    var runtime: Int = 0

    @ElementCollection(fetch = FetchType.EAGER)
    var genres: List<String> = mutableListOf()

    @Embedded
    var externals: Externals? = null

    @Embedded
    var image: Image? = null

    @Embedded
    var rating: Rating? = null

    @Embedded
    var network: Network? = null

    @Embedded
    var schedule: Schedule? = null

    @ElementCollection(fetch = FetchType.EAGER)
    var episodes: List<Episode>? = mutableListOf()
}