package fr.airweb.news

import android.app.Application
import fr.airweb.news.di.databaseModule
import fr.airweb.news.di.presentationModule
import fr.airweb.news.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()

            modules(repositoryModule)
            modules(presentationModule)
            modules(databaseModule)
        }
    }
}