package ro.jtonic.handson.springbapp.clientserver.client.hr

class BusinessFeignException(statusCode: Int)
    : RuntimeException("statusCode = $statusCode")
