package com.tvmazedatabase.episodes.model

import jakarta.persistence.Embeddable

@Embeddable
class Image {
    val medium: String = ""
    val original: String = ""
}