package com.hafnium.test.quarkus

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.Optional

@ExtendWith(MockitoExtension::class)
class GreetingServiceTest {
    private val greetingConfig = mock<GreetingConfig>()
    private val greetingRepository = mock<GreetingRepository>()

    private val greetingService = GreetingService(greetingConfig, greetingRepository)

    @Test
    fun `should generate greeting`() {
        whenever(greetingConfig.message()).thenReturn("Hi there")
        whenever(greetingRepository.findById(1)).thenReturn(Optional.of(GreetingEntity().apply {
            id = 1
            greeting = "Hello world!"
        }))

        val greeting = greetingService.greeting("Tester")

        assertThat(greeting).isEqualTo("Hi there Tester. Hello world!")
    }
}