package core.icore

import entity.User

interface IFilterManager {
    fun filterData(): List<User>
}