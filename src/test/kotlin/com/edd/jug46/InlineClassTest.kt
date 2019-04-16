package com.edd.jug46

import org.junit.jupiter.api.Test

class InlineClassTest {

    @Test
    fun `should use inline classes`() {
        registerUser(Username("Pete"), Email("pete@cool.com"))
    }
}

private inline class Username(val value: String)
private inline class Email(val value: String)

private fun registerUser(username: Username, email: Email) {
    println("Registering username=${username.value}, email=${email.value}")
}
