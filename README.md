# challenge
In this project, customer invoices are calculated

To run the project you must first of all bear in mind that the commons service must be compiled so that the jar is generated and you can add the maven dependencies in the pom.xml.

then, each of the other services is executed and the request is made in postman or in any http client as follows:

{"clientId": 3,
"date": "2018-03-04",
"direction": "cr 45 # 36 d sur 11",
"total": 0,
"products": [
{"productId": 6,
"quantity": 7,
"cost": 7},
{"productId": 3,
"quantity": 7,
"cost": 4},
{"productId": 6,
"quantity": 7,
"cost": 5}
]}
