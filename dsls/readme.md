

###Kotlin provides an amazing support for internal DSL.

#####It comprises of:

1. operator overloading 

      e.g:
        
        myMutableList += newElement

1. lambda with receivers

    e.g.
    
        StringBuilder.() -> Unit
    
1. infix functions

    e.g
    
        "myName" should start with "my"
         
1. invoke() method 

    eg: 
      
        val myService = MyService()
        myService() // this is equivalent to myService.invoke()
        
1.  Extension functions

    e.g.
    
        myMessage.log(INFO)  // myMessage is a string and it is extended with the support of logging it with Slf4j

1. Conventions for get (invoke, etc) methods

    e.g.
    
        myMap[key] = myMap.get[key]
        
        
1. Lambda outside the parentheses when it is the last argument

    e.g.:
      
        with(stringBuilder) { append("jtonic") }  
        

#####Projects:

1. **[under dev]** Provide a DSL over the apache POI library to the client.