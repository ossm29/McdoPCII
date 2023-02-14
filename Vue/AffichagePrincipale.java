package Vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarEntry;

public class AffichagePrincipale extends JPanel {

    private AffichageGauche affichageGauche;
    private AffichageDroite affichageDroite;

    public AffichagePrincipale(AffichageGauche affichageGauche, AffichageDroite affichageDroite){
        this.affichageGauche = affichageGauche;
        this.affichageDroite = affichageDroite;
        this.setPreferredSize(new Dimension(1420, 800));
        this.add(this.affichageGauche, BorderLayout.EAST);
        this.add(this.affichageDroite, BorderLayout.WEST);
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
