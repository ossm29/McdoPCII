package Controleur;

import Modele.Etat;
import Vue.AffichageServeur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  Class ControlDragDrop hérite de la classe 'MouseAdapter'
 * pour gérer le mouvement des produits de leur liste vers le plateau.
 *
 * @version 1.0
 * */
public class ControlDragDrop extends MouseAdapter {

    /** Variables utiles au modèle MVC */

    // L'affichage dans l'application
    private AffichageServeur affichageServeur;
    // L'état courant de l'application
    private Etat etat;

    /** Attributs */

    // Variable de type 'String' pour le produit glissé
    private String draggedProduct;

    // Variable de type 'Point' pour le point de départ du glissement
    private Point startPoint;

    // Variable de type 'JLabel' pour le label du produit glissé
    private JLabel draggedProductLabel;

    /**
     * Constructeur
     * Gère le mouvement des produits de leur liste vers le plateau
     *
     * @param etat              l'état actuel du modèle de type 'Etat'
     * @param affichageServeur  l'affichage de la vue de type 'AffichageServeur'
     * */
    public ControlDragDrop(Etat etat, AffichageServeur affichageServeur) {
        this.etat = etat;
        this.affichageServeur = affichageServeur;
    }


    /** Implémentations des méthodes de l'interface MouseAdapter */

    /**
     * Sélectionne un produit quand l'utilisateur presse la souris.
     *
     * @param e  l'évènement de la souris de type 'MouseEvent'
     * */
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        draggedProduct = affichageServeur.findProductAtPoint(startPoint);
        if (draggedProduct != null) {
            draggedProductLabel = createDraggedProductLabel(affichageServeur.getImage(draggedProduct));
            affichageServeur.add(draggedProductLabel);
            affichageServeur.setComponentZOrder(draggedProductLabel, 0);
            updateDraggedProductLabelPosition(e.getPoint());
        }
    }

    /**
     * Déplace le produit lorsque qu'il est glissé avec la souris
     *
     * @param e  l'évènement de la souris de type 'MouseEvent'
     * */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggedProductLabel != null) {
            updateDraggedProductLabelPosition(e.getPoint());
        }
    }

    /**
     * Dépose un le produit sélectionné et glissé sur le plateau
     * lorsque l'utilisateur relâche sa souris
     *
     * @param e  l'évènement de la souris de type 'MouseEvent'
     * */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggedProductLabel != null) {
            Point endPoint = e.getPoint();
            // Vérifie si le produit a été déposé dans le plateau et met à jour le modèle en conséquence.
            if (affichageServeur.isInTray(endPoint)) {
                // Ajoute la logique pour mettre à jour le modèle, si nécessaire.
                this.etat.addToTray(draggedProduct);
            }
            affichageServeur.remove(draggedProductLabel);
            affichageServeur.repaint();
            draggedProductLabel = null;
            draggedProduct = null;
        }
    }

    /**
     * Crée un label pour afficher l'image du produit qui a été glissé et déposé
     *
     * @param image  l'image à afficher sur le label de type 'Image'
     * @return label  le label du produit de type 'JLabel'
     * */
    private JLabel createDraggedProductLabel(Image image) {
        // Création d'une instance de ImageIcon avec l'image fournie,
        // redimensionnée à une taille de 30x30 pixels
        ImageIcon icon = new ImageIcon(image.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(icon);
        // Définition de la taille du label sur la taille de l'icône
        label.setSize(icon.getIconWidth(), icon.getIconHeight());
        return label;
    }

    /**
     * Mets à jour la position du label représentant du produit glissé et déposé
     *
     * @param point  la nouvelle position du label de type 'Point'
     * */
    private void updateDraggedProductLabelPosition(Point point) {
        // Calcul des décalages de position entre le point de départ
        // et la nouvelle position du point
        int xOffset = point.x - startPoint.x;
        int yOffset = point.y - startPoint.y;
        // Définition de la nouvelle position du JLabel en fonction
        // des décalages de position calculés
        draggedProductLabel.setLocation(startPoint.x + xOffset, startPoint.y + yOffset);
    }
}


