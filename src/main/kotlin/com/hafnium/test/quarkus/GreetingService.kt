package com.hafnium.test.quarkus

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
class GreetingService @Inject constructor(
    private val greetingConfig: GreetingConfig,
    private val greetingRepository: GreetingRepository,
) {
    @Transactional
    fun greeting(name: String): Greeting {
        val greeting = greetingRepository.load(1)?.greeting ?: "Hello quarkus!"

        return Greeting(name, greeting, "${greetingConfig.addressing()} $name. $greeting")
    }

    @Transactional
    fun changeGreeting(id: Int, greeting: String): GreetingEntity {
        val greetingEntity = greetingRepository.load(id) ?: GreetingEntity(id)
        greetingEntity.greeting = greeting
        greetingRepository.save(greetingEntity)

        return greetingEntity
    }
}
