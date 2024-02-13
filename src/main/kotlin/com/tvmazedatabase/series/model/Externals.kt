package com.tvmazedatabase.series.model

import jakarta.persistence.Embeddable

@Embeddable
class Externals {
    var imdb: String = ""
    var thetvdb: Int = 0
    var tvrage: Int = 0
}