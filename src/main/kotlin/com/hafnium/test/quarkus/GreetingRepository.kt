package com.hafnium.test.quarkus

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GreetingRepository : CrudRepository<GreetingEntity, Int> {
}