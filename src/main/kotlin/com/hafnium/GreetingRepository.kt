package com.hafnium

import org.springframework.data.repository.CrudRepository

interface GreetingRepository : CrudRepository<GreetingEntity, Int> {
}