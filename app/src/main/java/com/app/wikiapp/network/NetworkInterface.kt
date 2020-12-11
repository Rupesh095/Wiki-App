package com.app.wikiapp.network

import com.app.wikiapp.data.AppModel
import com.google.gson.JsonElement
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NetworkInterface {

    @Headers("Content-Type: application/json")
    @GET("w/api.php?action=query&prop=imageinfo&iiprop=timestamp%7Cuser%7Curl&generator=categorymembers&gcmtype=file&gcmtitle=Category:Featured_pictures_on_Wikimedia_Commons&format=json&utf8")
    fun getArticle() : Call<JsonElement>

//    @GET("restful_api/register_user.php")
//    fun registerUser(@Body appModel: AppModel) : Call<AppModel>

//    @POST("restful_api/login_user.php")
//    fun loginUser(@Body appModel: AppModel): Call<AppModel>

}