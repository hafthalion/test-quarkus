package com.hafnium.test.quarkus

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GreetingRepository : JpaRepository<GreetingEntity, Int> {
}