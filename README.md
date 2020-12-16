#Description

1.Designed microservice items-on-sale , which is further dependent on the orders-list , wishlist and hot-deals microservices .

2.Orders List returns the items ordered by the given user and sorted on the basis of rating .

3.Wishlist returns the items stored in the users wishlist .

4.Hot Deals returns the list of items sorted on average rating given by different users .

5.The list of items returned by these services are collected and returned by hitting the endpoint /recommendations/{userId}

6.We have implemented the service discovery pattern using Eureka . Created the microservices as Eureka Clients . 

All the Services are registered to Eureka Server .

7.items-on-sale , orders-list , wishlist and hot-deals are started on port 8081,8082,8083,8084 .

8.Discovery Server is at port 8761 .

9.We have implemented the circuit breaker and a fallback in a microservice architecture using Hystrix Framework.
We have failed it gracefully ,returning the default response to the user .
 after minimum **5** requests ,**50%** of failing requests , **2s** time out , if these conditions are met fallback method would be invoked .
 The sleep window is **5s**, after that a retry would be given .

10.Spring security feature to authenticate the users entered . H2 datasource is used . Users inserted via data.sql file . Bad credentials Found would be shown for the unauthorized users .

