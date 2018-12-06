Assessment Avantrip Service
===========================
This is a small API-REST service that verify if one flight is fraudulent.
The same service will calculate of scoring and determine if flight is fraudulent or not. In this service it could be configure the rules for determinate the scoring of the fraud and also the umbral for determinate if the flight is fraud or not, through of the scoring that caculated for flight 


Descripton API-REST Service:
============================
This API-REST service conten three modules descriptor to continue:
  
**1. Service Module:**
  This module content 2 methods:
  - **_POST /service/fraudulent:_** This method receive a body request and it determine if a flight is fraudulent or not.This method **RETURN Boolean** value that indicate the result for the flight buy.
  
  - **_POST /service/scoring:_** This method receive a body request and it determine for a flight.This method **RETURN Int** value that indicate the scoring for the flight buy.
  
  
**2. Config Module:**
  This module content 4th methods:
  - **_PUT /config/score:_** This Method update the **score** and **maxScoreFraud** where **score** is the scoring that determine if a flight is fraudutlent and **maxScoreFraud** is the max value for scoring for calculate.
  
  - **_GET /config/rules:_** This method get a list rules that will implement for calculate the scoring in a flight buy.
  
  - **_POST /config/rules:_** This method save one or a list rules that will implement for calculate the scoring in a flight buy.
  
  - **_PUT /config/rules:_** This method update one or a list rules that will implement for calculate the scoring in a flight buy.
  
  
  **3. Documentation Module:**
  This module content the documentation for API-REST service:
  - **_GET /swagger-ui.html:_** With this method you get all information for use the API-REST service.



**Technology implement**
========================
  - Spring boot 1.5.18
  - swagger2
  - easyRules 3.2
  - H2Database
  - junit
