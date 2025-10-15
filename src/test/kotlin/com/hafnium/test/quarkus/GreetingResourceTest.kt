package com.hafnium.test.quarkus

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.text.MatchesPattern.matchesPattern
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {
    @Test
    fun testHelloEndpoint() {
        given()
            .`when`().get("/hello")
            .then()
            .statusCode(200)
            .body(`is`(notNullValue()))
    }

    @Test
    fun testGreetingEndpoint() {
        given()
            .`when`().get("/hello/greeting/tester")
            .then()
            .statusCode(200)
            .body(matchesPattern("\\{.+tester.+\\}"))
    }
}
