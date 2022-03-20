package fr.airweb.news.presentation.fragment

import fr.airweb.news.R
import fr.airweb.news.databinding.FragmentNewsListBinding
import fr.airweb.news.presentation.model.NewsListState
import fr.airweb.news.presentation.viewmodel.NewsListViewModel



class NewsListFragment :
    BaseFragment<
            NewsListState,
            NewsListViewModel,
            FragmentNewsListBinding>(R.layout.fragment_news_list) {


                override fun updateView(state: NewsListState) {

                }
}