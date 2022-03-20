package fr.airweb.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.airweb.news.data.model.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}