package com.edd.jug46

class UserService {

    fun getUsers() = users

    fun getUser(id: Long) = users.find { it.id == id }
}

private val users = (1..10).map { id ->
    User(
        id = id.toLong(),
        username = "username-$id"
    )
}
