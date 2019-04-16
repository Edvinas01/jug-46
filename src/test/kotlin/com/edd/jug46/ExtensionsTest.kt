package com.edd.jug46

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

class ExtensionsTest {

    @Test
    fun `should convert null to json`() {
        // Works on nulls
        println(null.toJson())
    }

    @Test
    fun `should convert object to json`() {
        println(Picture("...").toJson())
    }

    @Test
    fun `should convert external object to json`() {
        println(listOf("Cool", "Stuff").toJson())
    }
}

private data class Picture(val url: String)

private val mapper = ObjectMapper()

private fun <T : Any?> T.toJson() = mapper.writeValueAsString(this)
