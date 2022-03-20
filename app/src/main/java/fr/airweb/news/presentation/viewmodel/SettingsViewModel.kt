package fr.airweb.news.presentation.viewmodel

import fr.airweb.news.R
import fr.airweb.news.presentation.model.SettingsState

class SettingsViewModel : BaseViewModel<SettingsState>(
    SettingsState()
) {

    init {
        _state.onNext(
            SettingsState(
                contactEmail = getEmail(),
                contactPhoneNumber = getPhoneNumber(),
                companyName = getCompanyName(),
                contactAddress = getAddress()
            )
        )
    }

    private fun getEmail() : String = resources.getString(R.string.contact_email)
    private fun getPhoneNumber() : String = resources.getString(R.string.contact_phone_number)
    private fun getCompanyName() : String = resources.getString(R.string.contact_company_name)
    private fun getAddress() : String = resources.getString(R.string.contact_address)

}