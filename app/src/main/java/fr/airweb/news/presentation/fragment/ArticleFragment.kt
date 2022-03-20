package fr.airweb.news.presentation.fragment

import fr.airweb.news.R
import fr.airweb.news.databinding.FragmentNewsListBinding
import fr.airweb.news.presentation.model.ArticleState
import fr.airweb.news.presentation.viewmodel.ArticleViewModel


class ArticleFragment :
    BaseFragment<
            ArticleState,
            ArticleViewModel,
            FragmentNewsListBinding>(R.layout.fragment_article) {


    override fun updateView(state: ArticleState) {

    }
}