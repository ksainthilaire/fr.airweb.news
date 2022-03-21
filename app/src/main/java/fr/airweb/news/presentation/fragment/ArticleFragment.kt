package fr.airweb.news.presentation.fragment

import fr.airweb.news.R
import fr.airweb.news.databinding.FragmentNewsListBinding
import fr.airweb.news.presentation.model.ArticleState
import fr.airweb.news.presentation.viewmodel.ArticleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleFragment :
    BaseFragment<
            ArticleState,
            ArticleViewModel,
            FragmentNewsListBinding>(R.layout.fragment_article) {

    override val viewModel: ArticleViewModel by viewModel()

    override fun updateView(state: ArticleState) {

    }
    override fun initView() {}
}