package com.tvmazedatabase.series.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
class Network {
    @Column(name = "network_id")
    var id: Int = 0

    @Column(name = "network_name")
    var name: String = ""

    @Column(name = "network_official_site")
    var officialSite: String? = ""

    @Embedded
    var country: Country? = null
}