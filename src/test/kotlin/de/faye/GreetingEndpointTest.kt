package de.faye

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingEndpointTest {

    @Test
    fun testGreetingEndpoint() {
        given()
          .`when`().get("/greeting?username=human")
          .then()
             .statusCode(200)
             .body(`is`("Welcome human"))
    }
}