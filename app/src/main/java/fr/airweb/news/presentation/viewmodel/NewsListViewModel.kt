package fr.airweb.news.presentation.viewmodel

import android.util.Log
import fr.airweb.news.data.repositories.NewsRepository
import fr.airweb.news.domain.model.TypeNews
import fr.airweb.news.presentation.model.NewsListState
import fr.airweb.news.presentation.model.SortBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { list ->
                val state =  NewsListState(isLoading = false, newsList = list)
                _state.onNext(state)
            }
    }

    fun searchArticleByTitle(title: String) {
        val previousState = _state.value!!
        val state = NewsListState(
            isLoading = false,
            newsList = previousState.newsList,
            searchedTitle = title,
            sortByType = previousState.sortByType,
            sortBy = previousState.sortBy
        )
        _state.onNext(state)
    }

    fun sortByType(type: TypeNews) {
        val previousState = _state.value!!
        val state = NewsListState(
            isLoading = false,
            newsList = previousState.newsList,
            searchedTitle = previousState.searchedTitle,
            sortBy = SortBy.DATE_ASC,
            sortByType = type
        )
        _state.onNext(state)
    }

    fun sortBy(sortBy: SortBy) {
        val previousState = _state.value!!
        val state = NewsListState(
            isLoading = false,
            newsList = previousState.newsList,
            searchedTitle = previousState.searchedTitle,
            sortByType = previousState.sortByType,
            sortBy = sortBy
        )
        _state.onNext(state)
    }
}