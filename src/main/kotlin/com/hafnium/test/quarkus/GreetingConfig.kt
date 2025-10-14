package com.hafnium.test.quarkus

import io.smallrye.config.ConfigMapping


@ConfigMapping(prefix = "greeting")
interface GreetingConfig {
    fun message(): String
}