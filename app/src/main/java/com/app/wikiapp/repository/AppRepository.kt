package com.app.wikiapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.wikiapp.data.AppModel
import com.app.wikiapp.network.RetrofitClient
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository {

    var articles : MutableLiveData<JSONObject>

    init {
        articles = MutableLiveData()
    }

    fun getArticle(): MutableLiveData<JSONObject> {

        RetrofitClient.service.getArticle().enqueue(object : Callback<JSONObject> {

            override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                Log.d("GETARTICLE", ""+t.message)
            }

            override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                articles.value = response.body()
                Log.d("GETARTICLE", ""+Gson().toJson(response.body()))

            }
        })
        return articles
    }

}