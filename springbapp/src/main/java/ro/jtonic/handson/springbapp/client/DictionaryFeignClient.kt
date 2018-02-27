package ro.jtonic.handson.springbapp.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.ws.rs.core.MediaType


/**
 * Created by Antonel Ernest Pazargic on 26/02/2018.
 * @author Antonel Ernest Pazargic
 */
@Service
@FeignClient(name = "https://dictionary")
interface DictionaryFeignClient {

    @GetMapping(value = ["api/v1/entries/en/{word}"], produces = [MediaType.APPLICATION_JSON])
    fun findWord(@PathVariable("word") storeId: String): String
}