package fr.airweb.news.presentation.model

import fr.airweb.news.domain.model.NewsDetails

class ArticleState(
    var isLoading: Boolean = true,
    var article: NewsDetails? = null
) : BaseState