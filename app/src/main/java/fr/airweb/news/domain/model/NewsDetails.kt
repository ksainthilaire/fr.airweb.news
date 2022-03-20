package fr.airweb.news.domain.model

import java.time.LocalDate

data class NewsDetails(
    var nid: Int? = null,
    var type: TypeNews,
    var date: LocalDate,
    var title: String? = null,
    var picture: String? = null,
    var content: String? = null,
    var dateformated: String? = null
)