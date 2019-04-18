package com.edd.jug46

import org.junit.jupiter.api.Test

class ExtensionsArrowTest {

    @Test
    fun `should convert null to json`() {
        val dog = Dog("Bork")
        println(resolveComment(dog))
    }
}

private data class Dog(val name: String)

private fun resolveComment(dog: Dog) = if (dog.name == "Bork") {
    "Dog is cool"
} else {
    try {
        throw Exception("Dog is not cool")
    } catch (e: Exception) {
        e.message
    }
}
