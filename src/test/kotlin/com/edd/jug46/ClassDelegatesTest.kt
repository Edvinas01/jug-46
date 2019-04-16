package com.edd.jug46

import org.junit.jupiter.api.Test

class ClassDelegatesTest {

    @Test
    fun `should use delegates`() {
        val confused = ConfusedAnimal(CoolAnimal())
        confused.walk()
        confused.eat()
    }
}

private class ConfusedAnimal(private val animal: Animal) : Animal by animal {
    override fun walk() = println("I'm not sure I wanna walk")
}

private class CoolAnimal : Animal {
    override fun walk() = println("I don't walk cuz I'm cool")
    override fun eat() = println("I don't eat cuz I'm cool")
}

private interface Animal {
    fun walk()
    fun eat()
}
