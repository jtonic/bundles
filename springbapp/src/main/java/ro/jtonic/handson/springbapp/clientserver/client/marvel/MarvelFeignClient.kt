package ro.jtonic.handson.springbapp.clientserver.client.marvel

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.ws.rs.core.MediaType


/**
 * Created by Antonel Ernest Pazargic on 26/02/2018.
 * @author Antonel Ernest Pazargic
 */
@FeignClient(name = "https://marvel", configuration = [MarvelFeignClientConfig::class])
interface MarvelFeignClient {

    @GetMapping(value = ["v1/public/characters?limit={limit}"], produces = [MediaType.APPLICATION_JSON])
    fun findCharacters(@RequestParam("limit") limit: Int): String
}
