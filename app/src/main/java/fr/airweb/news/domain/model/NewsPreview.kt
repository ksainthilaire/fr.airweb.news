package fr.airweb.news.domain.model

import java.time.LocalDate

data class NewsPreview(
    var nid: Int? = null,
    var type: TypeNews,
    var date: LocalDate,
    var title: String? = null,
    var picture: String? = null,
    var dateformated: String? = null
)