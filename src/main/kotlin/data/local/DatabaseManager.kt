package data.local

import entity.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query


class DatabaseManager {
    var  instance : Realm? = null

    private fun initRealm(): Realm {
        // Configure the Realm database
        val config = RealmConfiguration.Builder(
            schema = setOf(User::class) // Register the schema
        )
            .name("data.realm")
            .schemaVersion(1)
            .build()

        // Initialize Realm with the configuration
        return Realm.open(config)
    }


    suspend fun addUser(users: List<User>) {
        _getInstance().write {
            users.forEach {user ->
                this.copyToRealm(user)
            }
        }
    }

    suspend fun getAllUsers(): List<User> {
        val users = _getInstance().query<User>().find()
        return users
    }

    fun _getInstance() : Realm{
        if (instance == null){
            instance = initRealm()
            return instance as Realm
        }else{
            return instance!!

        }
    }
}
