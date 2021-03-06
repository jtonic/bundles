package ro.jtonic.handson.springbapp.clientserver.services.impl

import org.springframework.stereotype.Service
import ro.jtonic.handson.springbapp.clientserver.client.dictionary.DictionaryFeignClient

/**
 * Created by Antonel Ernest Pazargic on 26/02/2018.
 * @author Antonel Ernest Pazargic
 */
@Service
class DictionaryService (val dictionaryFeignClient: DictionaryFeignClient) {

    fun findWord(word: String) =
        dictionaryFeignClient.findWord(word)
}
