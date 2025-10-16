package com.hafnium.test.quarkus

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingRepository {
    fun load(id: Int) = findById(id)
    fun save(greetingEntity: GreetingEntity) = persist(greetingEntity)

    private companion object : PanacheRepositoryBase<GreetingEntity, Int>
}
