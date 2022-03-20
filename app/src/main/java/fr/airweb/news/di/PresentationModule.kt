package fr.airweb.news.di

import fr.airweb.news.presentation.viewmodel.ArticleViewModel
import fr.airweb.news.presentation.viewmodel.NewsListViewModel
import fr.airweb.news.presentation.viewmodel.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {

    viewModel { ArticleViewModel() }
    viewModel { NewsListViewModel() }
    viewModel { SettingsViewModel() }

}