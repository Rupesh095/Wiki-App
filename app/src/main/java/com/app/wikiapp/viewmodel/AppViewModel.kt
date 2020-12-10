package com.app.wikiapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.app.wikiapp.repository.AppRepository

class AppViewModel (application: Application) : AndroidViewModel(application) {

    var appRepository : AppRepository

    init {
        appRepository = AppRepository()
    }
}