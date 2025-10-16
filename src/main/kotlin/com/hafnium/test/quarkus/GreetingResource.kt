package com.hafnium.test.quarkus

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType

@Path("hello")
class GreetingResource @Inject constructor(
    private val greetingService: GreetingService,
) {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        return "Hello from Quarkus REST"
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("greeting/{name}")
    fun greeting(name: String): Greeting {
        return greetingService.greeting(name)
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("greetings/{id}")
    fun greetings(id: Int, @QueryParam("greeting") greeting: String): GreetingEntity {
        return greetingService.changeGreeting(id, greeting)
    }
}
