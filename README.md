# BrewDog Beer Library

## Introduction

Me and my team want to salute to BrewDog founders in our way: create a wonderful collection of their wonderful beers.

First, you will see a list of beers on the home page. If you click on one of the beer, you will dive deep into the beer's details like which food is a good pair for this beer, or what kind of malts do they use to brew it, etc.

You will find an area of inputs where you can filter the results. 
Don't you know, which beer would be a good match for your pizza? Don't worry! Just filter beers according to your actual food and we will tell you the answer! ;)

In our application, you can register yourself as a fan of BrewDog, pick your favorite beers and save it on your personal profile. You can delete them, if you would change your mind.

!!!! Frontend github link: https://github.com/BoczV/compassionate_beers_frontend !!!!


## Technologies

### Frontend
Mainly we used React on frontend side along with CSS.
Our authentication strategy is based on JWT tokens, which were saved on the client side dynamically to fulfill security.

You can find more information in the frontend git link: https://github.com/BoczV/compassionate_beers_frontend

### Backend
We used Spring Boot framework to create our backend side with Hibernate. Our backend has a micro-service based architecture with multiple services.

You can find the blueprint of our structure here:

![alt text](https://github.com/BoczV/compassionate_beers_backend/blob/master/./api-gateway/src/main/resources/microserviceStructure.png?raw=true)
