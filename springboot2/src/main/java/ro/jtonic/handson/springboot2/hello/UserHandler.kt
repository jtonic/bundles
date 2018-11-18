package ro.jtonic.handson.springboot2.hello

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class UserHandler {

    fun hello(request: ServerRequest): Mono<ServerResponse> = ServerResponse.ok().body(BodyInserters.fromObject("This is Tony"))
}
