package de.faye.greeting

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingService {
    fun greet(username: String?): String {
        return "Welcome $username"
    }
}