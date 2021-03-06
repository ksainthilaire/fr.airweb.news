package fr.airweb.news.di

import android.content.res.Resources
import fr.airweb.news.R
import fr.airweb.news.data.services.NewsApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val apiModule = module {

    single<OkHttpClient> {
        OkHttpClient().newBuilder().addInterceptor {
            val request = it.request()
                .newBuilder()
                .build()
            it.proceed(request)
        }.callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }




    single<Retrofit> {
        val httpClient = get<OkHttpClient>()
        val resources = get<Resources>()
        val baseUrl = resources.getString(R.string.api_airweb_base_url)

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single<NewsApi> {
        get<Retrofit>().create(NewsApi::class.java)
    }
}