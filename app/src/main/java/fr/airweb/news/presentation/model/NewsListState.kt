package fr.airweb.news.presentation.model

import fr.airweb.news.domain.model.NewsDetails
import fr.airweb.news.domain.model.NewsPreview
import fr.airweb.news.domain.model.TypeNews

class NewsListState(
    val isLoading: Boolean = true,
    val newsList: List<NewsPreview>? = null,
    val searchedTitle: String? = null,
    val sortByType: TypeNews? = TypeNews.NEWS,
    val sortBy: SortBy = SortBy.DATE_ASC
) : BaseState


enum class SortBy {
    DATE_ASC,
    DATE_DESC,

    TITLE_ASC,
    TITLE_DESC
}