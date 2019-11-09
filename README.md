# BricksCoding
Assessment 

Step1 : Since i am using Spring Boot with Maven i have added dependencies and plugins in pom.xml for Rest Application
Step2 : Create RestController for Rest APi
Step3 : Post request is used for creating the orders
Step4 : order object will be sent with number of bricks to buy and unique order id will be generated in the backend(currently generating in code)
Step5 : Once the order created, on success ,we can generate URI(header Location) with order ID using URI Component builder
Step6 : Customer orders of respective ID can be retrived using Get request and Order ID as RequestParam(query Param in URI)
Step7 : All the Customer oders can be retrieved using Get request and using list type
