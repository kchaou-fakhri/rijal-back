package entity


import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class User : RealmObject {

    @PrimaryKey
    var id: Long = 0
    var name: String = ""
    var birthDay: String = ""
    var deadDay: String = ""
    var description: String = ""
    var hisTeachers: RealmList<Long> =  realmListOf()
    var hisStudents: RealmList<Long> =  realmListOf()


}
