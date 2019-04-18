package com.edd.jug46

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.Routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    val server = embeddedServer(factory = Netty, port = 8080) {
        install(CallLogging)

        install(ContentNegotiation) {
            jackson {
                configure(SerializationFeature.INDENT_OUTPUT, true)
            }
        }

        install(Routing) {
            users(UserService())
        }
    }

    server.start(wait = true)
}
