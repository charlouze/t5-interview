# Talentroc tapestry5 interview test

Ceci est le test pour les entretiens chez Talentroc.

A minima, chaque exercice doit être ponctué d'un commit. Il est néanmoins possible de faire plusieurs commit pour un
exercice. Pensez à préciser dans le message de commit pour quel exercice il est (par exemple : "Ex1 - bla bla bla")

Si vous avez une remarque ou une question, contactez moi directement.

Vous pouvez évidemment en faire plus que le minimum demandé ici.

## Ressources utiles

* [Tapestry getting started](http://tapestry.apache.org/getting-started.html)
* [Tapestry component reference](http://tapestry.apache.org/component-reference.html)
* [Git book](http://git-scm.com/book)

## Lancement de l'application

Vous devez installer [maven 3.0.5](http://maven.apache.org/download.cgi) sur votre machine afin de pouvoir lancer le
projet.

Lancez une première fois l'application sans avoir effectué de modification afin de s'assurer que tout fonctionne :

```
mvn jetty:run
```

Accéder à l'application via le lien suivant : http://localhost:8080/t5-interview

## Exercices

### Exercice 1 : formulaire de contact

Il existe une page tapestry nommée _ContactEdit_ qui peut être trouvée dans le package _com.talentroc.t5.interview.pages.contact_

Cette page contient uniquement la routine d'activation en cas d'édition ou de création.

__Travail : Ajouter le formulaire de création d'un nouveau contact ansi que la routine pour le submit.__

### Exercice 2 : validation des données

Aucune données n'est validée et la méthode ContactManagerImpl.validate ne contient aucune instructions

Les contraintes de validation sont les suivantes :

* firstName :
  * maximum 50 caratères
* lastName :
  * requis
  * minimum 3 caractères
  * maximum 50 caratères
* telephone :
  * requis
  * minimum 10 caractères
  * maximum 10 caractères
  * seulement des chiffres

__Travail 1 : Ajouter la validation côté serveur dans la méthode validate de ContactManagerImpl.__
__Travail 2 : Ajouter la validation côté client via le système de validation de tapestry.__

### Exercice 3 : Bouton supprimer & éditer

Il existe une page tapestry nommée _ContactIndex_ qui peut être trouvée dans le package _com.talentroc.t5.interview.pages.contact_

Cette page liste les différentes entrées de contact.

__Travail : Ajouter les boutons supprimer et éditer dans le tableau pour chaque entrée de contact__

### Exercice 4 : Ajout d'une ville à un contact

La page ContactIndex permet d'afficher la liste des contacts avec les différentes informations les concernants.

__Travail 1: Ajouter une propriété ville à un contact et modifié le tableau afin de l'afficher.__ (Utiliser l'annotation @ManyToOne de JPA)

Lorsque le nombre de contact devient important, il peut être intéressant de permettre à l'utilisateur de trier les contacts en fonction d'une propriété. (Par exemple sa ville)

__Travail 2: Rajouter un filtre permettant d'afficher les contacts en fonction de leur ville à l'aide d'un composant dropdown de [bootstrap](http://getbootstrap.com/)__
