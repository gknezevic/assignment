# Assignment

## Running app

For running application from terminal, use following command:

`mvn spring-boot:run`

## Storage

App is using in memory H2 DB by default.
If you like to use H2 in File DB, replace application.properties with following value:

`spring.datasource.url=jdbc:h2:file:~/shopDB;DB_CLOSE_DELAY=-1`

## Sample curl

### Ceate Product

`curl -X POST
  http://localhost:8080/product
  -H 'Content-Type: application/json'
  -d '{
	"sku" : "1234",
	"name" : "T-Shirt",
	"price" : 19.99
}'`

`curl -X POST
  http://localhost:8080/product
  -H 'Content-Type: application/json'
  -d '{
    "sku" : "1234-342",
	"name" : "Shoes",
	"price" : 29.99
}'`

### Get All Products

`curl -X GET http://localhost:8080/product`

### Get Single Product

`curl -X GET http://localhost:8080/product/{sku}`

`curl -X GET http://localhost:8080/product/1234`

### Update Product

`curl -X PUT
   http://localhost:8080/product
   -H 'Content-Type: application/json'
   -d '{
 	"sku" : "1234",
 	"name" : "T-Shirt size L",
 	"price" : 39.99
 }'`
 
 ### Delete Product
 
 `curl -X DELETE http://localhost:8080/product/{sku}`
 
 `curl -X DELETE http://localhost:8080/product/1234`
 
 ### Place Order
 
  `curl -X POST
     http://localhost:8080/orders
     -H 'Content-Type: application/json'
     -d '{
   	"skuList" : [..., ...., ...],
   	"email" : email
   }'`
 
 `curl -X POST
    http://localhost:8080/orders
    -H 'Content-Type: application/json'
    -d '{
  	"skuList" : ["1234", "1234-342"],
  	"email" : "some_fake@email.com"
  }'`
  
  ### List Order in date range
  
  `curl -X GET http://localhost:8080/orders/{startDate}/{endDate}`
  
  `curl -X GET http://localhost:8080/orders/2018-12-03T10:15:30/2019-10-23T00:36:57`
  
  
  ## Swagger
  
  Swagger is available on
  
  `localhost:8080/swagger-ui.html`