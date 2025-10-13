package com.hafnium

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class GreetingService @Inject constructor(
    val greetingConfig: GreetingConfig,
) {
    fun greeting(name: String): String {
        return "${greetingConfig.message()} $name"
    }
}