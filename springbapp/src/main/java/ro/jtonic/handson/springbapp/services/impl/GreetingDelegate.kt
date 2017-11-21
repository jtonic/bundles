package ro.jtonic.handson.springbapp.services.impl

import org.springframework.stereotype.Component

@Component
class GreetingDelegate {

  fun greeting(name: String?) = "Greeting $name"
}