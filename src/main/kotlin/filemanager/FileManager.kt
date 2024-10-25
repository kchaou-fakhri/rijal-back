package filemanager

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import entity.User
import entity.dto.UserDTO
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import utils.Constants
import java.io.File
import java.lang.reflect.Type

suspend fun readJSON() : List<User> {
    val filePath = Constants.FILE_PATH
    val file = File(filePath)
    val userListType = object : TypeToken<List<User>>() {}.type

    val jsonString = file.readText()

    // Create Gson instance with custom RealmList deserializer
    val gson = GsonBuilder()
        .registerTypeAdapter(RealmList::class.java, RealmListDeserializer())
        .create()

    // Parse the JSON file into a list of users
    return gson.fromJson(jsonString, userListType)

}



class RealmListDeserializer : JsonDeserializer<RealmList<Long>> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): RealmList<Long> {
        val realmList = realmListOf<Long>()
        if (json.isJsonArray) {
            json.asJsonArray.forEach {
                realmList.add(it.asLong)
            }
        }
        return realmList
    }
}
