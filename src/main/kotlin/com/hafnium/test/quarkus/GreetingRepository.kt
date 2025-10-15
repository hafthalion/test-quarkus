package com.hafnium.test.quarkus

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingRepository : PanacheRepositoryBase<GreetingEntity, Int> {
}
