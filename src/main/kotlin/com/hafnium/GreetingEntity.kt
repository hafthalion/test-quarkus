package com.hafnium

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class GreetingEntity {
    @get:Id
    var id: Int? = null
    var greeting: String? = null
}
