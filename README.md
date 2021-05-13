# CPLAYERS - A Case Study

## PROBLEM STATEMENT
Build a system to search for a cricket player, get Recommendations and add players to favorite list. The 3 sections are:- Registration&  Login , Cplayer-Service- for adding, deleting, view all players,updating adding data of a player ,  Recommendations – view all recommendations, add to recommendations, delete from recommendations   ,  Favorite  - View all Favorite players under Favorite section- Display all Player statistics under View all players recommendations from 3rd party tracks service provider (cricapi) under recommendations section

### The application needs to fetch cricket players from the following API.
https://www.cricapi.com/


##Functional-Requirements:
1)User should be able to register in the system. Profile image should be uploaded during registration  A registered user should be able to login to the system
2) Favorite Service -View all Favorite players under Favorite section
3) Player Statistics - Display all Player statistics under Player statistics section
4) Recommendation service-  View all players recommendations from 3rdparty tracks service provider (cricapi) under recommendations section

##Non-Functional-Requirements:
a)App should be responsive to display consistently across multiple device screens.  
b)Dockerize the front-end (create Docker file,   docker-compose.ymland get it executed through docker compose)






Microservices required:

1) UserAuthenticationService
2) Cplayer-service
3) Recommendation service
4) Favourite service


Third party API: https://www.cricapi.com

## Tools and Technologies to be used :
1. VCS  :  Gitlab   2. Middleware :  SpringBoot     3.Frond end  :  Postman
   4.Data Store   :  MongoDB/MySQL        5.Testing   :  Junit, Mockito
   6.Containerization: Docker
____________________________________________

Services and Respective Ports
•	cplayer-service     - port  8081
•	User-Authentication  - port  8082
•	Recommendation-service  -  port 8083
•	favorite-service   - port  8084
•	CplayerZuulApi – port 8085
•	CPlayerEurerkaServer – port 8761



Building the UserAuthenticationService
1.	Created a server in Spring Boot to facilitate user registration and login using JWT token and MySQL
2.	Added E-mail validation and not null validations.
3.	Writing swagger documentation
4.	Write Test Cases


Building the PlayerRecommendationService
1. Created a server in Spring Boot for adding recommendation ,deleting , view all recommendation.    Counter is increased every time user add any recommendation
2. Build an API to get Recommendations
3. Writing Swagger Documentation
4. Write Test Cases
5. Zuul implemented




Building the CplayerService
1. Build a server in Spring boot  facilitate CRUD operation over to add various details of the player in  MongoDB.
2. Build an API to get Add ,Delete,Update Player details
3. Writing Swagger Documentation
4. Write Test Cases
   5.Zuul implemented



Building the Favourite Service
1.	Building a server in Spring Boot to facilitate CRUD operation over favourite players stored in MySQL
2.	Writing Swagger Documentation
3.	Write Test Cases
4.  Zuul implemented


- Create Eureka server and make other services as client

- Demonstrate the entire application