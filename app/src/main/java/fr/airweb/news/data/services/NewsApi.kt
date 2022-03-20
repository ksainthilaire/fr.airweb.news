package fr.airweb.news.data.services

import fr.airweb.news.data.model.NewsEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsApi {

    @GET("/psg/psg.json")
     fun getNews() : Observable<List<NewsEntity>>
}