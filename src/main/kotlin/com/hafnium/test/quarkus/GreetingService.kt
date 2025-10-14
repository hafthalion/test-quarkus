package com.hafnium.test.quarkus

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class GreetingService @Inject constructor(
    val greetingConfig: GreetingConfig,
    val greetingRepository: GreetingRepository,
) {
    fun greeting(name: String): String {
        val greeting = greetingRepository.findById(1).get().greeting
        return "${greetingConfig.message()} $name. $greeting"
    }
}