package com.hafnium

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GreetingRepository : CrudRepository<GreetingEntity, Int> {
}