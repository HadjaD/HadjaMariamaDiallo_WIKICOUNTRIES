# HadjaMariamaDiallo_WIKICOUNTRIES
Project Android Hadja Mariama DIALLO Groupe 31

Description: WikiCountries est une application qui permet d'afficher les informations générales sur tous les pays des trois continents Afrique, Europe et Asie. L'utilisateur va d'abord choisir un continent parmi ceux cités ci-avant puis il aura la liste de tous les pays de ce continent et pourra choisir d'afficher les informations sur un pays en particulier.

Cahier des charges:

  1.  Deux ecrans: Un ecran avec une liste et un écran avec un détail de l'item
  2.  Appel WebService a une API rest
  3.  Stockage des donnée en cache amélioration possible
  4.  Architecture
        Singleton
        Design Patterns
        MVC/MVP/MVVM
        Injection de dépendances
        Principes(SOLID,KISS,DRY)
   5. Gitflow
  6.  Animation entre les ecran
  7.  Notification Push(firebase)
  8.  Autre Fonctionnalité

Ce que je suis parvenue à faire:

. L'application contient quatre écrans:
  - Un écran d'accueil qui contiet deux Texview (le premier, le message de bienvenue, le deuxième, l'utilité) et un Button qui        permet de passer à l'activité suivante.
  
  En image:
  https://github.com/HadjaD/HadjaMariamaDiallo_WIKICOUNTRIES/issues/1#issue-455983745
 
 - Un deuxième écran qui permet de choisir un continent parmi les trois proposés: Une relative Layout qui intègre la carte du continent, son nom et un Button d'édition.
 
 En image:
 https://github.com/HadjaD/HadjaMariamaDiallo_WIKICOUNTRIES/issues/2#issue-455984394
 
 - Un troisième écran qui permet d'afficher les pays du continent choisi: Une recycler View qui s'adapte à un LinearLayout qui contient Une image (la carte du pays que Picasso n'a pas pu charger), son nom et qui implémente une écoute sur clic.
 
 En image:
 https://github.com/HadjaD/HadjaMariamaDiallo_WIKICOUNTRIES/issues/3#issue-455984855
 
 - Une dernière image qui permet d'afficher les informations concernant le pays choisi.
 https://github.com/HadjaD/HadjaMariamaDiallo_WIKICOUNTRIES/issues/1#issue-455983745
 
 . Appel webservice à l'API utilisée: https://restcountries.eu/rest/v2/all:
 . Stockage de données en cache:
 . Architecture utilisée: Model Vue Controller (ici mes vues sont dans le package Activity):
 
