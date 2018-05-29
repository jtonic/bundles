
####Spring boot application for learning/presentation purposes

* Spring MVC
* Spring Cloud
* Webflux (reactive stream programming)
* kotlin on backend and js frontend
* Spring security
* Spring microservices (spring cloud and netflix OSes)
* Spring cloud stream with kafka
* monitoring with graphite and grafana 

####Todo
* Feign
    * ~~simple feign client with a static list of servers~~ 
    * add nterceptor: 
        only for a single feign client
        default one - for all feign clients (I suppose this is the case when the interceptor is annotated with Component or Service)
    * Test the feign client in MVC mock test context - and check if the interceptor is called
    * 404 treated with decoder
    * create a feign decoder 
        * only for specific clients
        * for all clients
        
* MVC mock examples
    * check if some methods on 
    * MockMvc for test simplification and speed up the run time
    
    * use org.springframework.mock.web.MockHttpServletRequest to pass headers to the mocked request
    
* Use `@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)` to get HttpRequest things in a singleton bean


#### Fix the following
1. ClientApp cannot autowire Feign Clients

     




