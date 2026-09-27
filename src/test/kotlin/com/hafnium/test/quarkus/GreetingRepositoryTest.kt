package com.hafnium.test.quarkus

import io.quarkus.test.TestTransaction
import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingRepositoryTest {
    @Inject
    lateinit var greetingRepository: GreetingRepository

    @Inject
    lateinit var entityManager: EntityManager

    @Test
    @TestTransaction
    fun `should save and load`() {
        val entity = GreetingEntity(10, "Hello world!")

        greetingRepository.save(entity)
        entityManager.flush()
        entityManager.clear()
        val entityLoaded = greetingRepository.load(10)

        assertThat(entityLoaded).isNotSameAs(entity).isEqualTo(entity)
    }

    @Test
    @TestTransaction
    fun `should load nothing for unknown id`() {
        assertThat(greetingRepository.load(-1)).isNull()
    }
}
