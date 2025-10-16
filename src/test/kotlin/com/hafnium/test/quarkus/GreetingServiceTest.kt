package com.hafnium.test.quarkus

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
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
        whenever(greetingRepository.load(1)).thenReturn(
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
        whenever(greetingRepository.load(1)).thenReturn(null)

        val greeting = greetingService.greeting("Tester")

        assertThat(greeting).isEqualTo(Greeting("Tester", "Hello quarkus!", "Dear Tester. Hello quarkus!"))
    }

    @Test
    fun `should create greeting entity`() {
        whenever(greetingRepository.load(1)).thenReturn(null)
        whenever(greetingRepository.save(any<GreetingEntity>())).then { }

        val greeting = greetingService.changeGreeting(1, "Howdy!")

        assertThat(greeting).isEqualTo(GreetingEntity(1, "Howdy!"))
    }
}
