package com.hafnium.test.quarkus

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
class GreetingService @Inject constructor(
    val greetingConfig: GreetingConfig,
    val greetingRepository: GreetingRepository,
) {
    @Transactional
    fun greeting(name: String): Greeting {
        val greeting = greetingRepository.findById(1)?.greeting ?: "Hello quarkus!"

        return Greeting(name, greeting, "${greetingConfig.addressing()} $name. $greeting")
    }
}
