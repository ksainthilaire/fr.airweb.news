package fr.airweb.news.di

import fr.airweb.news.data.repositories.NewsRepository
import org.koin.dsl.module


val repositoryModule = module {

    single {
        NewsRepository()
    }

}