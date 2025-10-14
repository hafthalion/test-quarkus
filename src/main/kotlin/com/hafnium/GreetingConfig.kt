package com.hafnium

import io.smallrye.config.ConfigMapping


@ConfigMapping(prefix = "greeting")
interface GreetingConfig {
    fun message(): String
}