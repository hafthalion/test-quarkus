package com.hafnium.test.quarkus

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.startsWith
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {
    @Test
    fun `should say hello`() {
        given()
            .`when`().get("/hello")
            .then()
            .statusCode(200)
            .body(equalTo("Hello from Quarkus REST"))
    }

    @Test
    fun `should greet me`() {
        given()
            .`when`().get("/hello/greeting/tester")
            .then()
            .statusCode(200)
            .body("name", equalTo("tester"))
            .body("message", startsWith("Hi tester. "))
    }

    @Test
    fun `should set greeting message`() {
        given()
            .queryParam("greeting", "Changed Hello")
            .`when`().post("/hello/greetings/123")
            .then()
            .statusCode(200)
            .body("id", equalTo(123))
            .body("greeting", equalTo("Changed Hello"))
    }

    @Test
    fun `should reject missing greeting message`() {
        given()
            .`when`().post("/hello/greetings/124")
            .then()
            .statusCode(400)
    }

    @Test
    fun `should reject blank greeting message`() {
        given()
            .queryParam("greeting", " ")
            .`when`().post("/hello/greetings/124")
            .then()
            .statusCode(400)
    }

    @Test
    fun `should reject too long greeting message`() {
        given()
            .queryParam("greeting", "a".repeat(256))
            .`when`().post("/hello/greetings/124")
            .then()
            .statusCode(400)
    }
}
