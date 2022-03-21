package fr.airweb.news.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class NewsListApi(
    val news: List<NewsEntity>? = null
)
