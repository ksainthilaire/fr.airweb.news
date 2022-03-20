package fr.airweb.news.presentation.model

import fr.airweb.news.domain.model.NewsDetails
import fr.airweb.news.domain.model.NewsPreview

class NewsListState(
    val isLoading: Boolean = true,
    val newsList: List<NewsPreview>? = null
) : BaseState