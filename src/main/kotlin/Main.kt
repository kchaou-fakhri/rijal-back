import datamanager.data.local.DatabaseManager
import datamanager.data.local.FileManager
import datamanager.data.remote.NetworkManager
import datamanager.filemanager.readFromJson
import datamanager.filemanager.readJSON
import entity.Response
import io.realm.kotlin.internal.platform.runBlocking
import utils.Constants

fun main(args: Array<String>) {
    println("Hello...")
    println("Select what you want?")

}

private class Application {
    val net = NetworkManager()
    val db = DatabaseManager()
    val fileManager = FileManager()
    fun readJson() {
        runBlocking {
            readFromJson<Response>(Constants.HADITH_PATH)

        }
    }

    fun downloadAndSaveData() {
        runBlocking {
            val result = net.getHadith().also {
                fileManager.writeJson(it, Constants.JSON_PATH)
            }
        }
    }
}