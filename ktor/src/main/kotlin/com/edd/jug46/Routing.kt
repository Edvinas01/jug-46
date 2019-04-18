package com.edd.jug46

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.users(users: UserService) {
    route("/users") {
        get {
            call.respond(users.getUsers())
        }

        get("/{id}") {
            val rawId = call.parameters["id"]
            val id = rawId?.toLongOrNull()

            if (id == null) {
                badRequest("Path variable \"$rawId\" is invalid.")
            } else {
                val user = users.getUser(id)
                if (user == null) {
                    notFound("User $id, does not exist.")
                } else {
                    call.respond(user)
                }
            }
        }
    }
}
