package datamanager.data.local

import com.google.gson.Gson
import java.io.File
import java.nio.charset.StandardCharsets


class FileManager {

    fun <T> writeJson(data: T, path: String) {
        val gson = Gson()
        val result = gson.toJson(data)

        val file = File(path)
        file.parentFile.mkdir()
        file.writeText(result,  StandardCharsets.UTF_8)
    }

    fun getJson(responseBody: String): entity.Response? {
        val gson = Gson()
        return try {
            gson.fromJson(responseBody, entity.Response::class.java)
        } catch (e: Exception) {
            null
        }
    }
}