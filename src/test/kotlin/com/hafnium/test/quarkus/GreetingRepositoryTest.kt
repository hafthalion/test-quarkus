package com.hafnium.test.quarkus

import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingRepositoryTest {
    @Inject
    lateinit var greetingRepository: GreetingRepository

    @Test
    @Transactional
    fun `should save and load`() {
        val entity = GreetingEntity(10, "Hello world!")

        greetingRepository.save(entity)
        val entityLoaded = greetingRepository.load(10)

        assertThat(entityLoaded).isEqualTo(entity)
    }
}
