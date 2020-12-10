package com.app.wikiapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.wikiapp.data.AppModel
import com.app.wikiapp.repository.AppRepository
import kotlinx.coroutines.launch

class AppViewModel (application: Application) : AndroidViewModel(application) {

    var appRepository : AppRepository

    init {
        appRepository = AppRepository()
    }

    fun getArticle(): MutableLiveData<AppModel> = viewModelScope.launch{
        return appRepository.getArticle()
    }
}