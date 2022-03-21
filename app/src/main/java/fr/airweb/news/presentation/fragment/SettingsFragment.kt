package fr.airweb.news.presentation.fragment


import fr.airweb.news.R
import fr.airweb.news.databinding.FragmentNewsListBinding
import fr.airweb.news.presentation.model.SettingsState
import fr.airweb.news.presentation.viewmodel.SettingsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment :
    BaseFragment<
            SettingsState,
            SettingsViewModel,
            FragmentNewsListBinding>(R.layout.fragment_settings) {

    override val viewModel: SettingsViewModel by viewModel()

    override fun updateView(state: SettingsState) {

    }
    override fun initView() { }
}