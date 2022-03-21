package fr.airweb.news.presentation.fragment


import android.content.Intent
import android.net.Uri
import fr.airweb.news.R
import fr.airweb.news.databinding.FragmentSettingsBinding
import fr.airweb.news.presentation.model.SettingsState
import fr.airweb.news.presentation.viewmodel.SettingsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment :
    BaseFragment<
            SettingsState,
            SettingsViewModel,
            FragmentSettingsBinding>(R.layout.fragment_settings) {

    override val viewModel: SettingsViewModel by viewModel()

    override fun updateView(state: SettingsState) {}
    override fun initView() {
        with(binding) {
            contactAddress.setOnClickListener {
                val address = resources.getString(R.string.contact_address)
                val url: String = "https://www.google.com/maps/search/?api=1&query=" + address;
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
            contactEmail.setOnClickListener {
                val email = resources.getString(R.string.contact_email)
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:")
                intent.putExtra(Intent.EXTRA_EMAIL, email)
                startActivity(intent)
            }
            contactMobile.setOnClickListener {

            }
        }
    }
}