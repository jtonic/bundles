package ro.jtonic.handson.springbapp.clientserver.client.dictionary

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.ws.rs.core.MediaType


/**
 * Created by Antonel Ernest Pazargic on 26/02/2018.
 * @author Antonel Ernest Pazargic
 */
@FeignClient(name = "https://dictionary", configuration = [DictionaryFeignClientConfig::class])
interface DictionaryFeignClient {

    @GetMapping(value = ["api/v1/entries/en/{word}"], produces = [MediaType.APPLICATION_JSON])
    fun findWord(@PathVariable("word") storeId: String): String
}
