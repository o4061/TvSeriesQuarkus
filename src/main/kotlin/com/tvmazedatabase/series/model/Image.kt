package com.tvmazedatabase.series.model

import jakarta.persistence.Embeddable

@Embeddable
class Image {
    var medium: String = ""
    var original: String = ""
}