package ro.jtonic.handson.springbapp.client.hr

class BusinessFeignException(statusCode: Int)
    : RuntimeException("statusCode = $statusCode")
