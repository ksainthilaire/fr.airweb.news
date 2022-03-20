package fr.airweb.news.di

import android.content.res.Resources
import androidx.room.Room
import fr.airweb.news.data.local.AppDatabase
import fr.airweb.news.data.local.NewsDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<Resources> {
        androidContext().resources
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "database-airweb"
        ).build()
    }

    single {
        val database = get<AppDatabase>()
        database.newsDao()
    }
}