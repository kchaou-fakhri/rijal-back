import data.local.DatabaseManager
import data.remote.NetworkManager
import filemanager.readJSON
import io.realm.kotlin.internal.platform.runBlocking

fun main(args: Array<String>) {
    println("Starting...")
    val db = DatabaseManager()
    val net = NetworkManager()
    runBlocking {

        val result = net.getHadith()
        if (result != null) {
            println(result.hadiths.data[0].hadithArabic)
        }

     //  val result =  readJSON()
        //db.addUser(result)

//        db.getAllUsers().forEach{
//            println(it.hisStudents.toString())
//        }

    }
}