package ro.jtonic.handson.springbapp.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


/**
 * Created by Antonel Ernest Pazargic on 26/02/2018.
 * @author Antonel Ernest Pazargic
 */
@Service
@FeignClient(name = "dictionary")
interface DictionaryFeignClient {

    @GetMapping(value = ["/dictionary/{word}"], produces = ["text/plain"])
    fun findWord(@PathVariable("word") storeId: String): String
}