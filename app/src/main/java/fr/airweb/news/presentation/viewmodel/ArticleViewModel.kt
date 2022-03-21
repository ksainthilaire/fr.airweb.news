package fr.airweb.news.presentation.viewmodel

import fr.airweb.news.data.repositories.NewsRepository
import fr.airweb.news.presentation.model.ArticleState
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.java.KoinJavaComponent.inject

class ArticleViewModel : BaseViewModel<ArticleState>(
    ArticleState()
) {

    private val repository: NewsRepository by inject(NewsRepository::class.java)


    fun loadArticleById(newsId: Int) {
        repository.getNewsDetailsFromId(newsId)
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe { news ->
                val state = ArticleState(isLoading = false, article = news)
                _state.onNext(state)
            }
    }
}