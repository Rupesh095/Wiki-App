package com.app.wikiapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.app.wikiapp.data.AppModel
import com.app.wikiapp.repository.AppRepository

class AppViewModel (application: Application) : AndroidViewModel(application) {

    var appRepository : AppRepository

    init {
        appRepository = AppRepository()
    }

    fun getArticle(): MutableLiveData<AppModel> {
        return appRepository.getArticle()
    }
}