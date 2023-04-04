package Controleur;

import Modele.Etat;
import Vue.AffichageServeur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  Class ControlDragDrop hérite de la classe 'MouseAdapter'
 *  et change l'affichage de l'interface
 *  quand chaque produit est glissé et déposé par l'utilisateur
 *
 * @version 1.0
 * */
public class ControlDragDrop extends MouseAdapter {

    /**
     *  Variables utiles au modèle MVC
     * */
    private AffichageServeur affichageServeur;
    private Etat etat;

    /**
     *  Variable de type "String"
     * */
    private String draggedProduct;

    /**
     *  Variable de type "Point"
     * */
    private Point startPoint;

    /**
     *  Variable de type "JLabel"
     * */
    private JLabel draggedProductLabel;

    /**
     * Constructeur
     * Gère le mouvement des produits de leur liste vers le plateau
     *
     * @param affichageServeur  de type 'AffichageServeur'
     * @param etat  de type 'Etat'
     * */
    public ControlDragDrop(Etat etat, AffichageServeur affichageServeur) {
        this.etat = etat;
        this.affichageServeur = affichageServeur;
    }


    /**
     * Implémentations de 'MouseAdapter'
     * */


    /**
     * Sélectionne un produit quand je presse ma souris
     *
     * @param e  de type MouseEvent
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
     * Bouge le produit d'un endroit vers l'autre
     * quand je glisse ma souris
     *
     * @param e  de type MouseEvent
     * */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggedProductLabel != null) {
            updateDraggedProductLabelPosition(e.getPoint());
        }
    }

    /**
     * Dépose un le produit sélectionné et glissé
     * sur le plateau quand je relâche ma souris
     *
     * @param e  de type MouseEvent
     * */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggedProductLabel != null) {
            Point endPoint = e.getPoint();
            // Vérifier si le produit a été déposé dans le plateau et mettez à jour le modèle en conséquence.
            if (affichageServeur.isInTray(endPoint)) {
                // Ajouter la logique pour mettre à jour le modèle, si nécessaire.
                this.etat.addToTray(draggedProduct);
            }
            affichageServeur.remove(draggedProductLabel);
            affichageServeur.repaint();
            draggedProductLabel = null;
            draggedProduct = null;
        }
    }

    /**
     * Crée le label du produit qui est "drag et dropped"
     *
     * @param image  de type "Image"
     * @return label  de type JLabel
     * */
    private JLabel createDraggedProductLabel(Image image) {
        ImageIcon icon = new ImageIcon(image.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(icon);
        label.setSize(icon.getIconWidth(), icon.getIconHeight());
        return label;
    }

    /**
     * Mets à jour la position du label du produit sur l'écran
     *
     * @param point  de type "Point"
     * */
    private void updateDraggedProductLabelPosition(Point point) {
        int xOffset = point.x - startPoint.x;
        int yOffset = point.y - startPoint.y;
        draggedProductLabel.setLocation(startPoint.x + xOffset, startPoint.y + yOffset);
    }
}


