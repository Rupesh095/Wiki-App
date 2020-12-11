package com.app.wikiapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.wikiapp.data.AppModel
import com.app.wikiapp.network.RetrofitClient
import com.google.gson.Gson
import com.google.gson.JsonElement
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository {

    var articles : MutableLiveData<JsonElement>

    init {
        articles = MutableLiveData()
    }

    fun getArticle(): MutableLiveData<JsonElement> {

        RetrofitClient.service.getArticle().enqueue(object : Callback<JsonElement> {

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d("GETARTICLE", ""+t.message)
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                articles.value = response.body()
                Log.d("GETARTICLE", ""+Gson().toJson(response.body()))

            }
        })
        return articles
    }

}