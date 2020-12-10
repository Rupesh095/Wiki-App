package com.app.wikiapp.network

import com.app.wikiapp.network.NetworkInterface
import com.app.wikiapp.utils.Utils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {

    companion object {

        var client = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build()

        var retrofit = Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service : NetworkInterface = retrofit.create(NetworkInterface::class.java)

    }

}