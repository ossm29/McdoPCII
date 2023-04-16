# RAPPORT PROJET MCDO PCII #

- [RAPPORT PROJET MCDO PCII](#rapport-projet-mcdo-pcii)
  * [I. INTRODUCTION](#i-introduction)
  * [II. ANALYSE GLOBALE](#ii-analyse-globale)
  * [III. PLAN DE DÉVELOPPEMENT](#iii-plan-de-d-veloppement)
  * [IV. Conception générale](#iv-conception-g-n-rale)
  * [V. Conception détaillée :](#v-conception-d-taill-e--)
  * [VI. RÉSULTAT :](#vi-r-sultat--)
  * [VII. DOCUMENTATION UTILISATEUR :](#vii-documentation-utilisateur--)
  * [VIII. DOCUMENTATION DÉVELOPPEUR :](#viii-documentation-d-veloppeur--)
- [IV. CONCLUSION :</span>](#iv-conclusion----span-)


![](https://i.imgur.com/8suPRTo.gif)


## I. INTRODUCTION
 

Nous avons choisi de fonder notre projet sur un jeu se déroulant dans un restaurant. Initialement, nous avions envisagé un jeu de bataille spatial, mais nous avons réalisé que de nombreux groupes explorent déjà ce type de concepts. Par conséquent, nous avons opté pour une approche plus originale.



Nous avons donc choisi de réaliser un jeu restaurant inspiré de cooking fever. Les clients arrivent de droite à gauche, en file d’attente et réalisent des commandes générées aléatoirement. 

Pour préparer les commandes, il y a une fenêtre ingrédients qui permet de confectionner les produits  (burgers, les frites pizzas et wraps). Les autres aliments que l’on peut sélectionner sont les desserts, les boissons et les parts de gâteaux qui elles n’ont pas besoin d’être générés.

Le but du jeu est d’avoir le score maximal à la fin du jeu, ce qui correspond à l’argent récolté. Lorsque les clients arrivent dans le restaurant, ils ont un timer dont la durée varie selon le client. Ces derniers doivent être servis dans le temps imparti. Un client insatisfait quitte le restaurant. 

La partie se termine lorsqu'il y a 5 clients insatisfaits. 


## II. ANALYSE GLOBALE

 

Notre projet sera réalisé en Java en respectant le modèle MVC : nos classes seront réparties selon leur correspondance à la vue, au modèle ou au contrôleur.

Pour représenter les priorités accordées à chaque fonctionnalité, nous les coderons sur une échelle de 1 ( le plus prioritaire ) à 4 ( le plus optionnel ).

Pour décrire les principales fonctionnalités à implémenter, nous allons faire dans l’ordre comme si nous commencions le jeu.

Pour commencer, il faut déjà qu’il y ait des clients qui rentrent, c’est notre première fonctionnalité.  —  niveau moyen / 1

Ensuite, il faut qu’il y ait des commandes de passées : minimum 1 produit et maximum 6 produits. — niveau facile / 1

Puis il faut confectionner les commandes : si c’est une boisson, un dessert ou une pizza, il suffit de drag and drop l’objet sur le client concerné par la commande.

 — niveau moyen / 1

Sinon, il faut produire l’aliment : nous devons sélectionner les ingrédients nécessaires à sa production et une fois que tout ceux-ci sont sélectionnés, l’aliment est produit et à nouveau il faut le drag and drop sur le client concerné.

—  niveau difficile / 3

Une fois que tous les ingrédients pour un aliment sont sélectionnés, le bouton valider  enclenche un timer, une animation correspondant au timer est affichée sur le cercle qui décrit le stock du produit et à la fin de celui-ci, une quantité de produit est ajoutée.

— niveau moyen / 4

Plus le client attend, plus son timer diminue.

— niveau facile / 2

Cette jauge diminue à une vitesse aléatoire selon chaque client et lorsqu’elle est complètement vide, le client part sans payer.

— niveau facile / 2

Une fois la commande du client servie, il doit quitter le restaurant et le montant de sa commande est ajouté au score.

—  niveau facile / 1

La dernière fonctionnalité et pas la plus évidente est l’interface graphique : gérer l’affichage des clients dans la file d’attente les arrivées et départs,…

—  niveau difficile / 1


## III. PLAN DE DÉVELOPPEMENT

![](https://i.imgur.com/vBreqGr.png)

_entrée des clients et déplacement :_

durée estimée : 24 heures.

Il faut créer les clients et trouver un moyen de les différencier les uns des autres, autant graphiquement que dans notre code. Gestion de leur affichage et leur position dans l’interface dans un thread.

 

_création des commandes de clients :_

Durée estimée : 1 heure.

Il faut créer un menu dans lequel il y aura tous les ingrédients disponibles. Une commande ne pourra contenir que des produits se trouvant dans le menu. Une commande aura un nombre minimum et maximum de produits (ici entre 1 et 6). Certains produits auront un stock limité et pourront donc être confectionnés comme les pizzas et les burgers et d’autres non comme les boissons et les gâteaux (desserts). 

Chaque commande aura un prix qui sera égal à la somme des prix des produits commandés.

 

_création des produits:_

Durée estimée : 3 heures

Il faut créer des produits qui composeront notre menu. Seuls ces produits pourront constituer une commande. Chaque produit devra avoir un nom pour l’identifier dans le code, un prix afin de calculer le prix de la commande plus tard et une image qui lui sera associée. Les produits comme les pizzas, les wraps, les burgers, les frites seront à confectionner à l’aide d’ingrédients et les boissons et gâteaux seront générés automatiquement.

 

_création des ingrédients :_

Durée estimée : 3 heures

Il faut créer des ingrédients afin de confectionner nos produits. 

Pour cela, nous définissons des recettes :

les frites sont à base d’huile, de sel et de patates

les burgers sont à base de pain burger, viande, tomate

les wraps sont à base de galette, salade, poulet, fromage

les pizzas sont à base de pâte à pizza, tomate, fromage, sauce

 

_affichage/évolution du timer client:_

Durée estimée : 1 heure

Il faut que le timer (patience) du client diminue à mesure qu’il attend. La patience de chaque client ne sera pas toujours égale, certains ont un timer plus court que d’autres donc nous allons utiliser une fonction random pour que chaque client ait une patience différente. Cependant, cette patience devra être ni trop longue, ni trop courte afin que le jeu reste jouable et que l’on ne perde pas le client d’avance.

 

_départ du client :_

Durée estimée : 2 heures

Le départ du client peut être lié à deux causes :

- sa commande lui a été donnée dans son intégralité

Dans ce cas, nous devons ajouter le prix des produits commandés au score de la partie. 

- son timer a atteint zéro :

 Dans ce cas, la commande n’a pas été servie donc le score de la partie n’augmente pas et  on incrémente le nombre de clients insatisfaits.

Dans les deux cas, nous devons le représenter sur l’interface graphique en supprimant le client de la file d’attente et du panneau de contrôle.

 

_interface graphique :_

Durée estimée : tout le long du projet – 6 semaines

L’interface graphique représente une grande partie de notre projet. Nous devons afficher dans différents endroits les différentes composantes de notre jeu. 

Nous affichons en bas la liste des ingrédients pour confectionner les produits. 

Légèrement au-dessus nous mettons la liste des produits. 

Encore au-dessus, nous affichons le restaurant et les clients (file d’attente). 

A droite de la fenêtre se trouvent le ticket de caisse, et un panneau de contrôle avec le client sélectionné au-dessus. 

L’affichage est très animé : nous affichons certaines animations comme les notifications d’entrée d’un client dans le restaurant, des symboles afin de distinguer les ingrédients est sélectionnés, un onglet d’aide afin d’afficher les recettes des produits, un timer visuel afin de représenter le temps de production d’un produit. Les clients sont représentés par des images en mouvement (différentes) dans le panneau de contrôle et dans la file d’attente.

_générer des clients :_

Durée estimée : 4 jours

La génération des clients doit se faire en respectant la logique du jeu. Plusieurs clients ne pourront pas rentrer en même temps au risque de rendre le jeu trop compliqué. Si les clients s’enchaînent trop vite dès le début du jeu, le jeu deviendra trop difficile à jouer et le joueur perdra la partie sans avoir eu le temps d’y jouer.

_Fin de partie :_

Durée estimée : 1 heure

La fin de partie a lieu lorsqu’un nombre trop important de clients insatisfaits ( = partis avant d’avoir reçu leur commande) est détecté.  A la fin de la partie, le score final est affiché dans une nouvelle fenêtre et les clients arrêtent d’être générés.

 

 


## IV. Conception générale


![](https://i.imgur.com/nL9kNHn.png)


 Nous suivons le modèle MVC pour ce projet, nos classes seront donc dans des packages différents selon qu’elles agissent sur la vue, sur le modèle, ou sur le contrôle.


## V. Conception détaillée :

_Création des ingrédients :_

Les ingrédients sont affichés dans la barre d’ingrédients à l’aide de la classe AffichageIngredients qui étend un JPanel, qui peut donc afficher des éléments. 

Nous récupérons l’état actuel du jeu à l’aide de son attribut Etat qui nous permettra également de modifier l’état du jeu et nous définissons les dimensions de la fenêtre à l’aide des variables largeur et hauteur. Dans la méthode paint, nous dessinons la bordure, l’arrière plan, les ingrédients et la sélection. La méthode drawIngredients permet de dessiner les images des ingrédients que l’on récupère à partir de fichiers sur le JPanel.

 

_Création et affichage des commandes :_

 

Pour la création des commandes, nous avons tout d’abord créé une classe commande. Elle a pour attribut principal un ArrayList d’éléments de type “Produit”.

Dans le constructeur de notre classe, qui permet donc de créer une commande, nous initialisons un ArrayList vide de type Produits (la classe que nous avons créé). Nous initialisons un nouvel ArrayList de type String qui correspond à notre menu. Le menu est composé :

- de burgers   - de frites   	- de pizzas 	- de boissons - de gâteaux  - de wraps

Chaque commande possède une constante nbProduits qui correspond au nombre de produits par commande et qui est propre à chaque commande. Cette variable est initialisée aléatoirement est comprise entre 1 et 6 produits ( avec la fonction Random). Les produits de chaque commande sont choisis aléatoirement . Nous différencions deux catégories de produits :

 - les produits sans limite de stock :

            boissons et gâteaux

 - les produits à confectionner :

            frites, burgers, wraps et pizzas

Nous choisissons un élément aléatoire dans la liste menu à l’aide de la méthode nextInt de l’objet Random que l’on récupère dans une variable String : String nomProduit = menu.get(reference) ; et on supprime cet élément de la liste menu afin de ne pas le sélectionner à nouveau à l’aide de menu.remove(reference). On ajoute ce produit à la liste des commandes avec une quantité aléatoire comprise entre 1 et le nombre de produits restants de la commande.

Le nombre de produits restant est calculé en soustrayant le nombre de produits déjà ajouté à la quantité de produits de la commande ( déterminé à l’aide d’un random plus haut).

A l’aide des fonctions calculBurger(), calculFrites(), calculwrap(), calculBoisson(), calculGateau(), nous calculons la quantité de chaque produit dans la commande.

Pour finir, les commandes ont chacune un prix associé égal à la somme des prix de chaque produit de la commande. Cette somme est calculée à  l’aide d’une méthode publique getPrix() qui retourne un entier correspondant au prix total de la commande. Nous récupérons une HashMap contenant la liste des prix de chaque produit en appelant la méthode statique getPrixProduits() de la classe Etat. Nous itérons ensuite sur chaque produit de la commande à l’aide de la méthode getProduits() de l’objet courant this et pour chaque produit, nous ajoutons son prix au prix total, que nous renvoyons une fois la boucle for terminée. 

La classe AffichageCommande étend un JPanel, qui nous permet de définir un panneau affichant la commande du client actuel sous forme de ticket de caisse. Nous récupérons l’état actuel du jeu grâce à la classe Etat. 

La méthode paint créé une bordure noire d’un pixel d’épaisseur autour du panneau et rend le fond blanc. 

Nous utilisons ensuite une police importée qui sert à l’écriture des la commande sur le ticket de caisse. 

Si des clients sont présents, nous appelons la méthode drawDecor qui dessinera le fond de ticket de caisse en lisant l’image du fichier cible et en l’affichant à l’aide de la méthode g,drawImage, ainsi que le nom du client en cours et sa commande à à l’aide de la fonction afficheCommande. Cette méthode récupère la liste des produits de la commande ainsi que les prix de chaque produit depuis la classe Etat et itère à travers la commande pour afficher pour chaque produit sa quantité, son nom, et son prix sur le ticket. Le prix total est écrit en fin de ticket. 

Si aucun client n’est présent, il affichera « PAS DE COMMANDE... ».

![](https://i.imgur.com/7T0GIoP.png)
![](https://i.imgur.com/tNJLqOn.png)


 

 

 

 

 

 

 

 

 

 

_Création des produits :_

 

Pour la création des produits, nous utilisons la classe Produit. Les produits sont identifiés à l’aide de deux constantes de type String et int, représentant le nom du produit et sa quantité. Les produits boissons et gâteaux sont générés automatiquement et sont donc présents en quantité illimitée. En revanche, les produits pizzas, burger, wrap et frites doivent être générés grâce aux ingrédients de la classe Ingrédients. Les recettes sont les suivantes :

- frites → patates, huile, sel

- pizza → pâte à pizza, sauce, tomate, fromage

- burger → pain à burger , viande, fromage

- wrap → galette, salade, poulet, fromage

![](https://i.imgur.com/Y9kxdrI.png)



La sélection des ingrédients afin de faire un produit se fait à l’aide d’un HashSet selectionIngredients implémenté dans la classe Etat et qui contient tous les ingrédients sélectionnés pour faire un produit. Pour afficher cette sélection, nous utilisons une classe ControlIngredientsValider implémentant un Actionlistener. Une fois les ingrédients nécessaires à la confection d’un produit sélectionnés, cette classe permet de lancer la confection du produit, lance un timer différent selon le produit en création et affiche celui-ci au-dessus de l’icône du produit en question. Ce timer est généré à l’aide de la classe ControlIngredientsValider. Lorsque le bouton valider est cliqué ( que l’on détecte à l’aide d’un actionevent), la méthode actionPerformed se déclenche et celle-ci vérifie le produit généré par la méthode production() de l’objet Etat  et lance un timer associé au produit correspondant.

Le stock de chaque produit est représenté dans une Hashmap stockProduits dans la classe Etat.

_Affichage et évolution du timer:_

Dans la classe Client, nous mettons un timer initialisé aléatoirement entre 25 et 35 secondes, représentant le temps d’attente du client à l’aide du code this.timer = 25 + random.nextInt(10). Ce timer est mis à jour toutes les 0,2 secondes et si celui-ci atteint zéro, nous incrémentons le nombre de clients insatisfaits de un à l’aide de la méthode updateTimer() et Etat.updateClientsInsatsifaits(). Graphiquement, nous représenterons cette humeur à l’aide de la classe AffichageBarreDeProgression, nous affichons la jauge d’énervement des clients. Cette classe étend de la classe JProgressBar. Elle charge la police de caractères utilisée sur la barre de progression (angrybirds-regular.ttf) et définit sa taille à l’aide de la méthode setPreferredSize() tel que la taille de la barre sera de 320 pixels de large et 35 pixels de hauteur. Si un client est présent, son numéro sera indiqué sur la barre : « CLIENT N1 », en revanche si aucun client n’est dans le restaurant, la barre affichera « EN ATTENTE DE CLIENTS ». Le texte sera centré sur la barre de progression à l’aide de la méthode setStringPainted(true).

 

_Interface graphique :_

 

Nous avons travaillé sur l’interface graphique tout le long du projet puisque quasiment toutes nos fonctionnalités nécessitent d’être affichées pour l’utilisateur. Les fonctions d’affichage se trouvent dans le package Vue de notre projet. Pour organiser nos différents tableaux, nous avons utilisé des BorderLayout. Dans la classe AffichageDroite, qui étend un JPanel (utilisée pour représenter un panneau graphique), nous définissons les éléments à afficher à droite de la fenêtre. Nous récupérons les attributs de AffichageClient et AffichageCommande et à l’aide d’un BorderLayout, nous affichons en haut les éléments de affichageClient, et en bas les éléments de affichageCommandes. Dans la classe AffichageGauche, nous récupérons les éléments de AffichageProduits, AffichageServeur et AffichageIngrédients et nous positionnons en haut les éléments de affichageServeur et en bas ceux de AffichageIngrédients. Enfin, dans la fonction AffichagePrincipal, nous récupérons les éléments de AffichageDroite et AffichageGauche afin d’afficher les éléments de AffichageGauche à gauche (EAST), et ceux de AffichageDroite à droite (WEST) à l’aide d’un BorderLayout. Nous affichons le tout à l’aide de la fonction paintComponent prenant en paramètre un Graphics. A l’aide de la classe Repaint, nous mettons en place un thread qui s’exécute 24 fois par seconde pour fluidifier l’affichage à l’aide de la méthode run qui redessine la vue à chaque fois.

_Drag and drop :_

Le drag and drop nous sert ici pour glisser les produits sur le plateau . Tout d’abord, pour glisser les produits vers le plateau, nous utilisons la classe ControlDragDrop. Quand l’utilisateur presse la souris, nous le détectons à l’aide de MousePressed. Si la souris est pressée sur un produit, nous le détectons à l’aide de la méthode findProductAtPoint de la classe affichageServeur. Si une valeur est trouvée à l’aide de cette méthode, un Jlabel est créé pour afficher l’image du produit sélectionné. Grâce à la méthode mouseDragged, nous déplaçons le produit lorsqu’il est glissé avec la souris. La méthode mouseReleased dépose le produit sélectionné sur le plateau lorsque l’utilisateur relâche la souris. Nous vérifions que le produit est bien déposé dans le plateau à l’aide de la méthode isInTray de la classe affichageServeur et nous mettons à jour le modèle en conséquence. Grâce aux méthodes createDraggedProdctLabel et updateDraggedProductLabelPositiin, nous créons et mettons à jour le label représentant du produit glissé déposé.

 

 

_Gestion des notifications :_

 

Notre jeu comporte plusieurs notifications et animations :

- l’entrée d’un client        	

- affichage du score         	

- affichage des clients insatisfaits

Pour afficher les notifications, nous utilisons la méthode dessinerNotification. Celle-ci affiche le texte de la notification en noir sur un rectangle de couleur blanc. Pour afficher les recettes nous utilisons un bouton d’aide représenté par un point d’interrogation. Nous déclarons le bouton à l’aide d’un Jbutton. Nous définissons sa position à côté des produits afin que ce soit plus cohérent. Nous définissons ces dimensions et nous plaçons notre « ? » en noir sur un fond blanc, puis nous ajoutons le bouton au Jpanel.

Pour définir le score et les clients insatisfaits, nous utilisons la méthode drawStats. A l’aide de celle-ci, nous dessinons un carré blanc ou l’on affichons le score récupéré dans la classe Etat à l’aide de getScore. Ce score est converti en chaîne de caractères et affiché en rouge. Nous affichons également les clients insatisfaits à l’aide de la fonction getClients_insatisfaits de la classe Etat, et nous faisons de même avec le nombre de clients servis, mais cette fois à l’aide de la fonction getClients_servis, tous deux convertis en chaîne de caractères et écrits en noir dans un rectangle.

 

 Diagramme de classes du package Modèle :
![](https://i.imgur.com/zpePYiP.png)


 Diagramme de classes du package Vue :

![](https://i.imgur.com/ed3mWFZ.png)



Diagramme de classe du package Control

![](https://i.imgur.com/10vHWb4.png)


## VI. RÉSULTAT :

![](https://i.imgur.com/7QhpkhH.jpg)



## VII. DOCUMENTATION UTILISATEUR :

 

Afin de jouer à notre jeu, nous avons quelques recommandations et obligations. La première est qu’il faut disposer d’un IDE Java (tel que Intellij ou Eclipse) afin de faire fonctionner le jeu, avec la version 11 de la JDK au minimum. Afin d’exécuter le jeu, il faut tout d’abord le télécharger, puis le charger dans l’IDE de votre choix et ouvrir le projet. Ensuite, il faut se rendre dans la classe Main et exécuter le programme en cliquant sur le bouton Run as Java Application. Pour jouer, les clients se généreront automatiquement, cependant, le joueur aura la possibilité de cliquer soit sur les flèches dans le coin gauche, soit sur les flèches de son clavier afin de passer au client suivant ou précédent. Afin de produire des ingrédients, il suffit à l’utilisateur de cliquer sur les ingrédients puis sur la case valider à l’aide de la souris. Pour servir les clients, il suffira également de glisser les produits commandés et les déposer sur le plateau à l’aide de la souris.

 


## VIII. DOCUMENTATION DÉVELOPPEUR :

L’organisation du jeu n’est pas très compliquée. En effet, pour faire fonctionner le projet, il suffit de cliquer sur la fonction main et lancer le projet. La classe du main se trouve directement lorsque le projet s’ouvre. La classe AffichageServeur du package Vue est la plus fournie. Elle contient tous les éléments nécessaires à l’affichage complet du jeu : des clients aux animations, en passant par les ingrédients ainsi que les locaux.

Les principales constantes modifiables dans notre jeu sont l’environnement et les clients. En effet, il est tout à fait possible pour les développeurs de modifier l’aspect des clients : de leur donner un visage humain, que ce soit des animaux,… Il est également possible de changer les dimensions de chaque fenêtre facilement : d’agrandir ou rétrécir l’espace du restaurant, des ingrédients,… L’image représentant le restaurant est tout à fait modifiable, tout comme les variables telles que le timer d’attente de chaque client qui peut être accéléré ou ralenti. La consigne de fin de partie peut également être modifiée : le nombre de clients avant celle-ci peut être augmenté ou diminué, tout comme la vitesse de production des produits.

Nous aurions également pu implémenter d’autres fonctionnalités telles que l’affichage du taux d’énervement sur le bonhomme qui représente le client en restaurant. Nous aurions pu également afficher un grill pour faire cuire les ingrédients qui se déclencherait une fois l’ingrédient déposé en créant un nouveau JPanel.


# IV. CONCLUSION :</span> 


Nous avons réussi à implémenter notre jeu à peu près comme nous l’avions imaginé au début de ce projet. Nous avons notamment fait beaucoup d’efforts graphiquement et nous avons essayé de rendre le jeu le plus interactif possible pour l’utilisateur. Cependant, nous avons rencontré quelques difficultés tout d’abord à se mettre d’accord sur quelles fonctionnalités étaient le plus importantes à réaliser, et puis bien-sûr au niveau du code afin de mettre en place les différents JPanel ainsi qu’avec la gestion des threads simultanés et la modification des variables par ceux-ci. L’utilisation du modèle MVC dont nous n’étions pas toujours habitués nous a permis de bien structurer nos idées et ne pas mélanger nos classes et nos fonctions. Il y a encore de nombreuses améliorations à faire à notre projet afin de le rendre le plus agréable possible cependant nous sommes déjà fiers du travail accompli !

Avec plus de temps, nous aurions rendu le jeu plus flexible en ajoutant des paramètres de difficulté permettant de modifier la durée du timer des clients, et la fréquence de génération de ceux-ci.
