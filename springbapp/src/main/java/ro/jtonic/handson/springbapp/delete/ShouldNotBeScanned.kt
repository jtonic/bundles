package ro.jtonic.handson.springbapp.delete

import ro.jtonic.handson.springbapp.client.FeignConfiguration
import javax.annotation.PostConstruct

/**
 * Created by Antonel Ernest Pazargic on 25/03/2018.
 * @author Antonel Ernest Pazargic
 */
@FeignConfiguration
class ShouldNotBeScanned {


    @PostConstruct
    fun post() {
        println("It's scanned!!!")
    }
}