package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;

public class AffichagePrincipal extends JPanel {

    private AffichageGauche affichageGauche;
    private AffichageDroite affichageDroite;

    public AffichagePrincipal(AffichageGauche affichageGauche, AffichageDroite affichageDroite){
        this.affichageGauche = affichageGauche;
        this.affichageDroite = affichageDroite;
        this.setPreferredSize(new Dimension(Modele.Etat.WIDTH, Etat.HEIGHT));
        this.add(this.affichageGauche, BorderLayout.EAST);
        this.add(this.affichageDroite, BorderLayout.WEST);
    }

    public AffichageGauche getAffichageGauche(){
        return this.affichageGauche;
    }
    public AffichageDroite getAffichageDroite(){
        return this.affichageDroite;
    }

    @Override
    public void paintComponent(Graphics g) {
        setBackground(Color.WHITE);
        super.paintComponent(g);

        /*// Méthode 1
        ImageIcon image = new ImageIcon("burger.png");
        g.drawImage(image.getImage(),200,600, 100, 100, null);*/

        // Méthode 2
        /*File file = new File("Vue/burger.png");
        try {
            this.paintBurger(g);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }

    /* Je dessine mon Burger de mon panel de stockage de produits */
    /*public void paintBurger(Graphics g) throws IOException {
        File file = new File("Vue/burger.png");
        Image image = ImageIO.read(file);
        g.drawImage(image, 100, 0, 50, 50,null);
    }*/


}
