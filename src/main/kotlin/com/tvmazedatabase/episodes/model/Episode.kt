package com.tvmazedatabase.episodes.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
class Episode : PanacheEntityBase() {
    val id: Int = 0

    @JsonProperty("airdate")
    val airDate: String = ""

    @JsonProperty("airstamp")
    val airStamp: String = ""
    val airtime: String = ""
    val name: String = ""
    val number: Int = 0
    val runtime: Int = 0
    val season: Int = 0

    @Column(length = 2048)
    val summary: String = ""
    val type: String = ""
    val url: String = ""

    @Embedded
    val image: Image? = null
}