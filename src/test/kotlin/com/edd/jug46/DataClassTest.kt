package com.edd.jug46

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DataClassTest {

    @Test
    fun `should use data classes`() {
val first = Carl(id = 1, lastName = "Carlson", name = "Carl ofc")
println(first)

val second = first.copy()
val third = first.copy(id = 3)

assertTrue(first == second)
assertTrue(first != third)
    }
}

private data class Carl(
    val id: Long,
    val lastName: String,
    val name: String
)
