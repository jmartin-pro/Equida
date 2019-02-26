# Java

De manière globales, tous les termes techniques doivent être en anglais (ex. ``Controller``).

Les mots métiers restent dans leur langue dont le terme est issu (bien souvent en français, ex. ``Lieu``) 

# Git

## Format du message :

Contenu en français et explicite, sous la forme :

    <type>\[(<scope>)\] : <subject>
    
    \[body\]
    
    \[footer\]
    
Exemple :

    feat(lieu): Ajout de la création d’un lieu
    
    <body>
    
    <footer>

### Valeurs de \<type\> autorisées :

* __feat__ : nouvelle fonctionnalité pour l’utilisateur, n’est pas une nouvelle fonctionnalité pour les scripts de compilation
* __fix__ : correction de bug fix pour l’utilisateur, n’est pas une correction pour les scripts de compilation
* __docs__ : modification de la documentation
* __style__ : formatting, missing semi colons, etc; pas de changement du code de production
* __refactor__ : refactoring du code de production, ex. renommer une variable
* __test__ : ajout de tests manquant, refactoring de tests; pas de changement du code de production
* __chore__ : mise à jour des tâches Maven, etc; pas de changement du code de production

### Exemples valeurs de \<scope\> (optionnel) :

    lieu
    cheval
    etc.

### Example valeurs de \<footer\> :

Espace réservé à une référence ou un lien vers une source ; très utile pour les bugs.

Exemple : un lien vers une carte Trello.

## Branches :

Evolutions dans une branche features/<evol>, où <evol> est composé de mots séparé par des tirets hauts "-".
Les termes techniques doivent être en anglais (ex. ``edit``) ; les mots métiers restent dans leur langue dont le terme est issu (bien souvent en français, ex. ``apporteur``).

Exemple :

    feature/edit-apporteur

