package com.hafnium.test.quarkus

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
class GreetingServiceTest {
    private val greetingConfig = mock<GreetingConfig>()
    private val greetingRepository = mock<GreetingRepository>()

    private val greetingService = GreetingService(greetingConfig, greetingRepository)

    @Test
    fun `should generate greeting`() {
        whenever(greetingConfig.addressing()).thenReturn("Dear")
        whenever(greetingRepository.findById(1)).thenReturn(
            GreetingEntity(
                id = 1,
                greeting = "Hello world!",
            )
        )

        val greeting = greetingService.greeting("Tester")

        assertThat(greeting).isEqualTo(Greeting("Tester", "Hello world!", "Dear Tester. Hello world!"))
    }

    @Test
    fun `should generate default greeting`() {
        whenever(greetingConfig.addressing()).thenReturn("Dear")
        whenever(greetingRepository.findById(1)).thenReturn(null)

        val greeting = greetingService.greeting("Tester")

        assertThat(greeting).isEqualTo(Greeting("Tester", "Hello quarkus!", "Dear Tester. Hello quarkus!"))
    }
}
