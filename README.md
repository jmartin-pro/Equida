# Présentation
Créée en 2006, Equida est une société spécialisée dans la vente aux enchères de chevaux de course. Pour être plus proche de sa clientèle étrangère, elle s’appuie sur une quinzaine de correspondants répartis dans de nombreux pays comme l’Irlande, la Turquie, ou encore le Japon.

Il s'agit de créer une application unique permettant de gérer :

- les informations sur les chevaux (caractéristiques, courses, origine du cheval, etc.)
- le catalogue des ventes et l'envoi de courriels aux différents clients intéressés par les ventes.

L'application devra également prendre en compte :
- la consultation du catalogue des ventes ;
- la consultation des résultats d’une vente ;
- la consultation en ligne de statistiques sur les ventes passées.

# Structuration du projet

Le projet comporte 3 dossiers :
- doc → Regroupe les différents documents importants du projet
- sql → Contient l'historique de tous les scripts (SQL ou PHP) qui ont modifié la BDD.
- src → Contient le code source de l'application

Concernant le dossier src celui contient un dossier "ionic" contenant tout le code de l'application mobile, ainsi qu'un dossier "Spring" contenant tout le code de l'application web à savoir l'api, le site web et la partie commune aux 2.

Le Trello utilisé pour le projet est disponible ici : https://trello.com/b/jrKixhpu/equida-spring

# Bibliothèques/Framework utilisées

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Materialize](https://materializecss.com/) 
- [JQuery](https://jquery.com/)
- [Ionic](https://ionicframework.com/)

# Authentification

L'authentification est géré par le biais de Spring. Concernant l'API il s'agit d'une authentification avec Basic Access Authentification (https://en.wikipedia.org/wiki/Basic\_access\_authentication). De ce fait l'utilisation du SSL est primordial afin de permettre une sécuristation du mot de passe qui pourrait être très facilement intercepté.

## Roles

L'API propose 2 roles pour le moment.

- ADMIN pour exécuter des actions tels que l'ajout d'une vente ou d'une race. 
- USER pour exécuter des actions tels que la mise en vente d'un cheval.

## Identifiants

Voici les différents identifiants pour le site.

### Client 

login : cdeltour

mdp : test

role : USER

### Directeur Général

login : nfime

mdp : test

role : ADMIN
