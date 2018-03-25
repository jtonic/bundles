package ro.jtonic.handson.springbapp.client.marvel

import feign.RequestInterceptor
import feign.RequestTemplate
import org.apache.commons.codec.digest.DigestUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Antonel Ernest Pazargic on 27/02/2018.
 * @author Antonel Ernest Pazargic
 */
const val PUBLIC_KEY = "0aad9058e396ce7cfc396d1027c84a13"
const val PRIVATE_KEY = "3a6fc3446171a069e05d3f68183690f164ea0971"
val ts = System.currentTimeMillis().toString()

//@Component //uncomment this and all feign clients requests will be affected by this interceptor
class MarvelFeignInterceptor : RequestInterceptor {

    companion object {

        @JvmField
        val LOG: Logger = LoggerFactory.getLogger(MarvelFeignInterceptor::class.java)
    }

    override fun apply(template: RequestTemplate?) {
        println("In interceptor 2")
        val digest = computeMd5(ts, PRIVATE_KEY, PUBLIC_KEY)
        template?.run {
            query("apikey", PUBLIC_KEY)
                    query("ts", ts)
            query("hash", digest)
        }
    }

    fun computeMd5(ts: String, privateKey: String, publicKey: String): String {
        val input = "$ts$privateKey$publicKey"
        val hash = DigestUtils.md5Hex(input.toByteArray())!!
        LOG.debug("hash = $hash")
        return hash
    }
}