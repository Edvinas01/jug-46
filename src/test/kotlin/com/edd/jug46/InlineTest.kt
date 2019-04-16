package com.edd.jug46

import org.junit.jupiter.api.Test

class Inline {

    @Test
    fun `should inline function`() {
        withName {
            println(it)
        }
    }

    @Test
    fun `should inline transform`() {
        val names = listOf("Pete", "Carl").map {
            it.toLowerCase()
        }

        println(names)
    }

    @Test
    fun `should not inline transform`() {
        val names = listOf("Pete", "Carl")
            .asSequence()
            .map {
                it.toLowerCase()
            }
            .toList()

        println(names)
    }
}

private inline fun withName(body: (String) -> Unit) {
    body("Pete")
}
