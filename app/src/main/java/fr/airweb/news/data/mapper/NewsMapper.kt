package fr.airweb.news.data.mapper

import fr.airweb.news.data.model.NewsEntity
import fr.airweb.news.domain.model.NewsDetails
import fr.airweb.news.domain.model.NewsPreview
import fr.airweb.news.domain.model.TypeNews
import java.time.LocalDate

object NewsMapper {

    private fun mapNewsType(type: String?): TypeNews = when (type) {
        "actualité" -> TypeNews.ACTUALITY
        "news" -> TypeNews.NEWS
        "hot" -> TypeNews.HOT
        else ->  TypeNews.UNDEFINED
    }

    fun newsEntityToNewsDetails(news: NewsEntity)  : NewsDetails = NewsDetails(
        nid = news.nid,
        type = mapNewsType(news.type),
        date = LocalDate.parse(news.date),
        title = news.title,
        picture = news.picture,
        content = news.content,
        dateformated = news.dateformated
    )


    fun newsEntityToNewsPreview(news: NewsEntity)  : NewsPreview = NewsPreview (
        nid = news.nid,
        type = mapNewsType(news.type),
        date = LocalDate.parse(news.date),
        title = news.title,
        picture = news.picture,
        dateformated = news.dateformated
    )
}