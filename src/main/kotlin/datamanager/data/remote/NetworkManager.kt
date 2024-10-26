package datamanager.data.remote

import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import datamanager.data.local.FileManager
import entity.Response
import io.realm.kotlin.internal.platform.runBlocking
import utils.Constants

class NetworkManager {

    suspend fun getHadith(): Response? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .addHeader("Accept-Charset", "UTF-8")
            .url("${Constants.BASE_URL}${Constants.API_KEY}")
            .build()

        val response = client.newCall(request).execute()
        return if (response.isSuccessful) {
            FileManager().getJson(response.body().string())
        } else {
            null
        }

    }


}