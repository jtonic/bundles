package ro.jtonic.handson.springbapp.clientserver.client.hr

import feign.Response
import feign.codec.ErrorDecoder
import java.lang.Exception

class BusinessErrorDecoder : ErrorDecoder {

    private val defaultDecoder = ErrorDecoder.Default()

    override fun decode(methodKey: String?, response: Response?): Exception {

        return response!!.run {
            val status = status()
            when (status) {
                400, 404, 414, 417 -> throw BusinessFeignException(404)
                in 500..599 -> throw UnidentifiedFeignException(status)
                else -> defaultDecoder.decode(methodKey, response)
            }
        }
    }
}
