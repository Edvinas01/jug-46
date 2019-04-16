package com.edd.jug46

import io.kotlintest.inspectors.forAll
import io.kotlintest.matchers.string.shouldContainIgnoringCase
import io.kotlintest.specs.StringSpec

class KotlinTestTest : StringSpec({
    "all cats should be cool" {
        val cats = listOf(
            Cat("Big cool Bertha"),
            Cat("Cool Smudge")
        )

        cats.forAll { (name) ->
            name shouldContainIgnoringCase "cool"
        }
    }
})

private data class Cat(val name: String)
