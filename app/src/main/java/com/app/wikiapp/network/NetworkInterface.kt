package com.app.wikiapp.network

import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET

interface NetworkInterface {

    @GET("w/api.php?format=json&action=query&generator=random&grnnamespace=0&prop=revisions%7Cimages&rvprop=content&grnlimit=10")
    fun getArticle() : Call<JSONObject>

//    @GET("restful_api/register_user.php")
//    fun registerUser(@Body appModel: AppModel) : Call<AppModel>

//    @POST("restful_api/login_user.php")
//    fun loginUser(@Body appModel: AppModel): Call<AppModel>

}