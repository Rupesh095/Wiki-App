package com.app.wikiapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.wikiapp.data.AppModel
import com.app.wikiapp.network.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository {

    var articles : MutableLiveData<AppModel>

    init {
        articles = MutableLiveData()
    }

    suspend fun getArticle(): MutableLiveData<AppModel> {

        RetrofitClient.service.getArticle().enqueue(object : Callback<AppModel> {

            override fun onFailure(call: Call<AppModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<AppModel>, response: Response<AppModel>) {
                articles.value = response.body()
                Log.d("GETARTICLE", Gson().toJson(articles))
            }
        })
        return articles
    }

}