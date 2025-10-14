package com.hafnium

import io.smallrye.config.ConfigMapping
import io.smallrye.config.WithName


@ConfigMapping(prefix = "greeting")
interface GreetingConfig {
    @get:WithName("message")
    val message: String
}