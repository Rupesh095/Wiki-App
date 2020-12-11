package com.app.wikiapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.wikiapp.data.AppModel
import com.app.wikiapp.repository.AppRepository
import com.google.gson.JsonElement
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONObject

class AppViewModel (application: Application) : AndroidViewModel(application) {

    var appRepository : AppRepository

    init {
        appRepository = AppRepository()
    }

    fun getArticle(): MutableLiveData<JsonElement> {
        return appRepository.getArticle()
    }

}