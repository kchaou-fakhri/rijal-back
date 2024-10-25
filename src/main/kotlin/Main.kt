import data.local.DatabaseManager
import data.local.FileManager
import data.remote.NetworkManager
import filemanager.readJSON
import io.realm.kotlin.internal.platform.runBlocking
import utils.Constants

fun main(args: Array<String>) {
    println("Starting...")
    val db = DatabaseManager()
    val net = NetworkManager()
    val fileManager = FileManager()
    runBlocking {

        val result = net.getHadith().also {
            fileManager.writeJson(it, Constants.JSON_PATH)
        }


     //  val result =  readJSON()
        //db.addUser(result)

//        db.getAllUsers().forEach{
//            println(it.hisStudents.toString())
//        }

    }
}