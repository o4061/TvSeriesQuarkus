package com.tvmazedatabase.series.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Country {
    var code: String = ""
    var timezone: String = ""

    @Column(name = "country_name")
    var name: String = ""
}