package fr.airweb.news.presentation.fragment


import fr.airweb.news.R
import fr.airweb.news.databinding.FragmentNewsListBinding
import fr.airweb.news.presentation.model.SettingsState
import fr.airweb.news.presentation.viewmodel.SettingsViewModel

class SettingsFragment :
    BaseFragment<
            SettingsState,
            SettingsViewModel,
            FragmentNewsListBinding>(R.layout.fragment_settings) {


    override fun updateView(state: SettingsState) {

    }
}