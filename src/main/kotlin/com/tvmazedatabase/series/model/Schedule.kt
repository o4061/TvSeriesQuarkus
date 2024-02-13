package com.tvmazedatabase.series.model

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.ElementCollection
import jakarta.persistence.Embeddable
import jakarta.persistence.FetchType

@Embeddable
class Schedule : PanacheEntityBase() {
    @ElementCollection(fetch = FetchType.EAGER)
    var days: List<String> = mutableListOf()
    var time: String = ""
}