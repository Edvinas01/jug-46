package com.edd.jug46

import arrow.core.getOrElse
import arrow.core.toOption
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class NullSafetyTest {

    @Test
    fun `should resolve length`() {
        val name: String? = " Pete "
        assertTrue(name?.trim()?.length == 4)
    }

    @Test
    fun `should lowercase`() {
        val name: String? = " Pete "
        if (name != null) {
            assertTrue(name.toLowerCase().contains("pete") ?: false)
        } else {
            fail("name was not lower-cased")
        }
    }

    @Test
    fun `should normalize name`() {
        val name: String? = " Pete "

        val normalized = name
            .toOption()
            .map(String::trim)
            .map(String::toLowerCase)
            .getOrElse { "name is empty" }

        assertTrue(normalized == "pete")
    }
}
