package com.edd.jug46

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Test

class Reified {

    @Test
    fun `should figure out type`() {
        val type = resolveType {
            "Hello there"
        }

        println(type)
    }

    @Test
    fun `should figure use specified json type`() {
        val mapper = ObjectMapper().registerKotlinModule()
        val json = """{"username":"Pete"}"""

        println(mapper.readValue<User>(json))
    }

    @Test
    fun `should figure out json type`() {
        val mapper = ObjectMapper().registerKotlinModule()
        val json = """{"username":"Pete"}"""

        print(mapper.readValue(json))
    }
}

private inline fun <reified T> resolveType(body: () -> T): String {
    body()
    return T::class.java.simpleName
}

private data class User(val username: String)

private fun print(user: User) {
    println(user)
}
