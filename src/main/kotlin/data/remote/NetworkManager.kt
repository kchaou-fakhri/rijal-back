package data.remote

import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import io.realm.kotlin.internal.platform.runBlocking
import utils.Constants

class NetworkManager {

    suspend fun getHadith(): entity.Response? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("${Constants.BASE_URL}${Constants.API_KEY}")
            .build()

        return runBlocking {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                response.body().string()?.let { body ->
                    getGson(body)
                }
            } else {
                null
            }
        }
    }

    fun getGson(responseBody: String): entity.Response? {
        val gson = Gson()
        return try {
            gson.fromJson(responseBody, entity.Response::class.java)
        } catch (e: Exception) {
            null
        }
    }

}