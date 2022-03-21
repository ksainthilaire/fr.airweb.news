package fr.airweb.news.data.repositories

import android.util.Log
import fr.airweb.news.data.local.NewsDao
import fr.airweb.news.data.mapper.NewsMapper
import fr.airweb.news.data.model.NewsEntity
import fr.airweb.news.data.model.NewsListApi
import fr.airweb.news.data.services.NewsApi
import fr.airweb.news.domain.INewsRepository
import fr.airweb.news.domain.model.NewsDetails
import fr.airweb.news.domain.model.NewsPreview
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.koin.java.KoinJavaComponent.inject

class NewsRepository : INewsRepository {

    private val newsDao: NewsDao by inject(NewsDao::class.java)
    private val newsApi: NewsApi by inject(NewsApi::class.java)

    companion object {
        private const val TAG = "NewsRepository"
    }

    fun getNewsDetailsFromId(id: Int): Observable<NewsDetails> =
        Observable.create { emitter ->
            fetchByIdFromLocal(id)
                .map(NewsMapper::newsEntityToNewsDetails)
                .subscribe({ news -> emitter.onNext(news) }, { tr ->
                    Log.e(TAG, "Error while retrieving an article from the local database", tr)
                })
        }

    fun getNewsPreviews(): Flowable<List<NewsPreview>?> = Flowable.create({ emitter ->
        val cachedData = fetchAllFromLocal()
            .map { news -> news.map(NewsMapper::newsEntityToNewsPreview) }
            .subscribe({ news -> emitter.onNext(news) },
                { tr -> Log.e(TAG, "Error while retrieving data locally", tr) })

        fetchAllFromRemote()
            .subscribe({ result ->
                cachedData.dispose()
                result.news?.let { saveRemoteData(result.news) }
                fetchAllFromLocal()
                    .map { news -> news.map(NewsMapper::newsEntityToNewsPreview) }
                    .onErrorReturnItem(listOf())
                    .subscribe(emitter::onNext)
            }, { tr -> Log.e(TAG, "Error while retrieving data remotely", tr) })
    }, BackpressureStrategy.BUFFER)

    private fun fetchByIdFromLocal(id: Int): Observable<NewsEntity> = newsDao.getNewsById(id)

    private fun fetchAllFromLocal(): Observable<List<NewsEntity>> = newsDao.getAllNews()

    private fun fetchAllFromRemote(): Observable<NewsListApi> = newsApi.getNews()

    private fun saveRemoteData(entities: List<NewsEntity>) = newsDao.insertAll(entities)
}