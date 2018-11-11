package ro.jtonic.handson.springbapp.clientserver.client.dictionary

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


/**
 * Created by Antonel Ernest Pazargic on 26/02/2018.
 * @author Antonel Ernest Pazargic
 */
@FeignClient(name = "https://dictionary", configuration = [DictionaryFeignClientConfig::class])
interface DictionaryFeignClient {

    @GetMapping(value = ["api/v1/entries/en/{word}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findWord(@PathVariable("word") storeId: String): String
}
