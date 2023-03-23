package Controleur;

import Vue.AffichageServeur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlDragDrop extends MouseAdapter {
    private AffichageServeur affichageServeur;
    private String draggedProduct;
    private Point startPoint;
    private JLabel draggedProductLabel;

    /** Constructeur */
    public ControlDragDrop(AffichageServeur affichageServeur) {
        this.affichageServeur = affichageServeur;
    }

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

    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggedProductLabel != null) {
            updateDraggedProductLabelPosition(e.getPoint());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggedProductLabel != null) {
            Point endPoint = e.getPoint();
            // Vérifier si le produit a été déposé dans le plateau et mettez à jour le modèle en conséquence.
            if (affichageServeur.isInTray(endPoint)) {
                // Ajouter la logique pour mettre à jour le modèle, si nécessaire.
            }
            affichageServeur.remove(draggedProductLabel);
            affichageServeur.repaint();
            draggedProductLabel = null;
            draggedProduct = null;
        }
    }

    private JLabel createDraggedProductLabel(Image image) {
        ImageIcon icon = new ImageIcon(image.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(icon);
        label.setSize(icon.getIconWidth(), icon.getIconHeight());
        return label;
    }

    private void updateDraggedProductLabelPosition(Point point) {
        int xOffset = point.x - startPoint.x;
        int yOffset = point.y - startPoint.y;
        draggedProductLabel.setLocation(startPoint.x + xOffset, startPoint.y + yOffset);
    }
}


