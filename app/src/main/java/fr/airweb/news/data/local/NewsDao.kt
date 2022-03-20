package fr.airweb.news.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.airweb.news.data.model.NewsEntity
import io.reactivex.Observable

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    fun getAllNews(): Observable<List<NewsEntity>>

    @Query("SELECT * FROM news WHERE nid LIKE :nid LIMIT 1")
    fun getNewsById(nid: Int) : Observable<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(news: List<NewsEntity>)


}