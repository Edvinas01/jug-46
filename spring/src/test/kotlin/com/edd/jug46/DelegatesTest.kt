package com.edd.jug46

import org.junit.jupiter.api.Test
import kotlin.reflect.KProperty

class DelegatesTest {

    @Test
    fun `should not fetch file content`() {
        File()
    }

    @Test
    fun `should fetch file content`() {
        println(File().content)
    }

    @Test
    fun `should fetch remote file content once`() {
        val file = RemoteFile()
        println(file.content)
        println(file.content)
    }
}


private class File {
    val content: String by lazy {
        println("Fetching file content")
        "Hello there"
    }
}

private class RemoteFile { val content: String by CustomDelegate() }

private class CustomDelegate {

    private var stored : String? = null

    operator fun getValue(ref: Any, prop: KProperty<*>): String {
        if (stored == null) {
            println("Fetching remote content")
            stored = "Content"
        }
        return stored as String
    }
}
