package com.app.wikiapp.network

import com.app.wikiapp.data.AppModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkInterface {

    @GET("w/api.php?format=json&action=query&generator=random&grnnamespace=0&prop=revisions%7Cimages&rvprop=content&grnlimit=10")
    fun getAppData(@Body appModel: AppModel) : Call<AppModel>

//    @GET("restful_api/register_user.php")
//    fun registerUser(@Body appModel: AppModel) : Call<AppModel>

//    @POST("restful_api/login_user.php")
//    fun loginUser(@Body appModel: AppModel): Call<AppModel>

}