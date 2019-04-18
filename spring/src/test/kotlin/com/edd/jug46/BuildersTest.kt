package com.edd.jug46

import org.junit.jupiter.api.Test

class BuildersTest {

    @Test
    fun `should use builder`() {
        val something = something {
            id = 123L
            name = "Some name"

            stuff {
                content = "Some content"
            }

            stuff {
                content = "Some other content"
            }
        }

        println(something)
    }
}

private data class Stuff(val content: String)
private data class Something(val id: Long, val name: String, val stuffs: List<Stuff>)

private class StuffBuilder {
    var content = ""
}

private class SomethingBuilder {

    var id = 0L
    var name = "Some name"

    val stuffs = mutableListOf<Stuff>()

    fun stuff(body: StuffBuilder.() -> Unit) {
        stuffs.add(
            Stuff(
                StuffBuilder()
                    .apply(body)
                    .content
            )
        )
    }
}

private fun something(body: SomethingBuilder.() -> Unit) = SomethingBuilder()
    .apply(body)
    .let { builder ->
        Something(
            id = builder.id,
            name = builder.name,
            stuffs = builder.stuffs
        )
    }
