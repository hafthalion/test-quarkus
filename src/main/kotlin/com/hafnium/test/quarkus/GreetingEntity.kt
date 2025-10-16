package com.hafnium.test.quarkus

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class GreetingEntity(
    @Id
    var id: Int = 0,
    var greeting: String = "",
)
