package fr.airweb.news.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey val nid: Int,
    @ColumnInfo(name = "type") val type: String? = null,
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "picture") val picture: String? = null,
    @ColumnInfo(name = "date") val date: String? = null,
    @ColumnInfo(name = "content") val content: String? = null,
    @ColumnInfo(name = "dateformated") val dateformated: String? = null
)
