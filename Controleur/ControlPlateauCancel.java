package Controleur;

import Modele.Etat;
import Vue.AffichageServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPlateauCancel implements ActionListener {
    private Etat etat;
    private AffichageServeur affichage;

    public ControlPlateauCancel(Etat etat, AffichageServeur affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.etat.clearTray();
        this.affichage.repaint();
    }
}
