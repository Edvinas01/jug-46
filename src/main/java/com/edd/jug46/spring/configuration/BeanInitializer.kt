package com.edd.jug46.spring.configuration

import com.edd.jug46.spring.domain.User
import com.edd.jug46.spring.domain.UserRepository
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

class BeanInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(ctx: GenericApplicationContext) =
        beans().initialize(ctx)
}

class LongGenerator {
    fun generate() = System.nanoTime()
}

class UserGenerator(private val generator: LongGenerator, private val users: UserRepository) {
    fun generate() = users.save(
        User(
            "username-${generator.generate()}",
            "picture-${generator.generate()}",
            emptyList()
        )
    )
}

private fun beans() = beans {
    bean {
        LongGenerator()
    }
    bean {
        UserGenerator(
            generator = ref(),
            users = ref()
        )
    }
}
