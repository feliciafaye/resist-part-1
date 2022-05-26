package de.faye.greeting

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("greeting")
class GreetingEndpoint(
    private val greetingService: GreetingService
) {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun greeting(@QueryParam("username") username: String?) = greetingService.greet(username)
}
