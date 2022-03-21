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

    fun getNewsDetailsFromId(id: Int): Observable<NewsDetails> =
        Observable.create { emitter ->
            fetchByIdFromLocal(id)
                .map(NewsMapper::newsEntityToNewsDetails)
                .onErrorReturnItem(null)
                .subscribe(emitter::onNext)
        }

    fun getNewsPreviews(): Flowable<List<NewsPreview>?> = Flowable.create( { emitter ->
        val cachedData = fetchAllFromLocal()
            .map { news -> news.map(NewsMapper::newsEntityToNewsPreview) }
            .subscribe(emitter::onNext)

        fetchAllFromRemote()
            .subscribe { result ->
                Log.d("TAG", "J'ai reçu les données")
                cachedData.dispose()
                result.news?.let { saveRemoteData(result.news) }
                fetchAllFromLocal()
                    .map { news -> news.map(NewsMapper::newsEntityToNewsPreview) }
                    .onErrorReturnItem(listOf())
                    .subscribe(emitter::onNext)
            }
    }, BackpressureStrategy.BUFFER)

    private fun fetchByIdFromLocal(id: Int): Observable<NewsEntity> = newsDao.getNewsById(id)

    private fun fetchAllFromLocal(): Observable<List<NewsEntity>> = newsDao.getAllNews()

    private fun fetchAllFromRemote(): Observable<NewsListApi> = newsApi.getNews()

    private fun saveRemoteData(entities: List<NewsEntity>) = newsDao.insertAll(entities)
}