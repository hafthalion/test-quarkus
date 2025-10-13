package com.hafnium

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class GreetingService @Inject constructor(
    val greetingConfig: GreetingConfig,
    val greetingRepository: GreetingRepository,
) {
    fun greeting(name: String): String {
        return "${greetingConfig.message()} $name. ${greetingRepository.findById(1).get().greeting}"
    }
}