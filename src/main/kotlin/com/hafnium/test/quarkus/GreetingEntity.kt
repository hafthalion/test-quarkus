package com.hafnium.test.quarkus

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class GreetingEntity {
    @get:Id
    var id: Int = 0
    var greeting: String? = null
}
