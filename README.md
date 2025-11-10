# Memory JavaFX (Projet d’entraînement POO)

## Objectif du projet

Ce projet est un **jeu de Memory** développé en **JavaFX**, sans utilisation de **Scene Builder**, dans le but de **maîtriser la conception logicielle orientée objet (POO)** et de **structurer proprement une application JavaFX**.

Il s’agit d’un projet d’entraînement visant à appliquer les principes de conception logicielle :

- **Encapsulation**
- **Héritage**
- **Polymorphisme**
- **Responsabilité unique (SRP)**
- **Architecture MVC/MVVM**

---

## Fonctionnalités actuelles

### Plateau de jeu dynamique

- Génération d’un plateau de cartes à partir d’un modèle configurable.
- Possibilité de jouer **seul ou à plusieurs** (sélection du nombre de joueurs au démarrage).

### Mise à jour en temps réel

- Les résultats (cartes retournées, paires trouvées, tours de jeu) sont **mis à jour dynamiquement** dans l’interface.

### Personnalisation de l’apparence

- Changement de la **couleur du plateau** via les paramètres du jeu.

### Architecture claire et modulaire

- Séparation entre les **modèles (Model)**, les **vues (View)** et les **contrôleurs (Controller)**.
- Aucune interface générée automatiquement (tout est **codé à la main** pour bien comprendre la logique JavaFX).

---

## Fonctionnalités à venir

- **Historique des parties** : sauvegarde des scores, temps de jeu et vainqueurs.
- **Système de sauvegarde/chargement** : reprendre une partie en cours.
- **Statistiques globales** : nombre total de parties jouées, taux de réussite, etc.

---

## 🧱 Architecture du projet

```bash
src/
├── controllers/       # Contrôleurs JavaFX : gèrent les interactions et la logique d'interface
├── entities/          # Entités principales du jeu (cartes, joueurs, plateau, etc.)
├── enums/             # Énumérations (types de cartes, états, couleurs, etc.)
├── gamelauncher/      # Classe responsables du lancement et de l’initialisation du jeu
├── handlers/          # Gestionnaires d’événements (souris, actions de jeu)
├── images/            # Ressources graphiques du jeu (icônes, dos de cartes, etc.)
├── interfaces/        # Interfaces Java définissant les contrats entre classes
├── manager/           # Gestionnaires logiques (gestion du score, du tour, du plateau, etc.)
├── services/          # Services métiers (sauvegarde, historique, etc.)
├── utils/             # Outils utilitaires (méthodes utiles dans tout le projet)
├── views/             # Classes de vues JavaFX (scènes, layouts, composants visuels)
├── visualcontent/     # Contenu graphique spécifique (éléments visuels personnalisés)
└── Main.java          # Point d’entrée principal de l’application JavaFX
```
