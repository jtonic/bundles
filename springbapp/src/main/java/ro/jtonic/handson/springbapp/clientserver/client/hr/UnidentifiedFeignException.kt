package ro.jtonic.handson.springbapp.clientserver.client.hr

class UnidentifiedFeignException(status: Int)
    : RuntimeException("Unidentified exception. Code: $status" as String?)
