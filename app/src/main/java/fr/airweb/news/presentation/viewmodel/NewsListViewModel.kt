package fr.airweb.news.presentation.viewmodel

import fr.airweb.news.data.repositories.NewsRepository
import fr.airweb.news.presentation.model.NewsListState
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.java.KoinJavaComponent.inject

class NewsListViewModel : BaseViewModel<NewsListState>(
    NewsListState()
) {
    private val repository: NewsRepository by inject(NewsRepository::class.java)

    init {
        getAllArticles()
    }

    private fun getAllArticles() {
        repository.getNewsPreviews()
            .subscribeOn(AndroidSchedulers.mainThread())
            .map { news ->
                NewsListState(
                    isLoading = false,
                    newsList = news
                )
            }
            .subscribe(_state::onNext)
    }

}