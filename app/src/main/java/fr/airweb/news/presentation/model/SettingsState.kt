package fr.airweb.news.presentation.model

class SettingsState(
    var contactEmail : String? = null,
    var contactPhoneNumber: String? = null,
    var companyName: String? = null,
    var contactAddress: String? = null,
) : BaseState