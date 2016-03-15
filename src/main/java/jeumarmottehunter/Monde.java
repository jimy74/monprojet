package jeumarmottehunter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class Monde extends JFrame implements ActionListener {

//Déclaration des attributs
    //Tableau de cases
    private ArrayList<Case> cases = new ArrayList<Case>(); //avec instanciation direct pour ne pas le faire avant utilisation

    private int tailleX;
    private int tailleY;

    //Constructeur
    Monde(int tailleX, int tailleY) {
        super("Titre");  //met le titre de la fenêtre

        this.tailleX = tailleX;
        this.tailleY = tailleY;

		
        //définit l'arrêt de l'application lors de la fermeture UI
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Interdit de redimensionner le monde
        setResizable(false);
        
        //Crée une zone d'affichage
        JPanel zoneAffichage = new JPanel();

        //Crée la zone pour le plateau de jeu
        JPanel zoneJeu = new JPanel();

        //Définit le Layout manager de la fenêtre en GridLayout de taille X,Y
        setLayout(new GridLayout(tailleX, tailleY));
        
        
        //Instanciation des cases ("parfois appelé le tableau ...")
        
        //pour toutes les colonnes
        for (int y = 1; y <= tailleY; y++) {
            //pour toutes les lignes 
            for (int x = 1; x <= tailleX; x++) {
                Case nouvelleCase = new Case(x, y);
                cases.add(nouvelleCase); //ajoute la nouvelle case dans la liste de cases
                nouvelleCase.addActionListener(this); //lie la gestion d'événement au monde
                add(nouvelleCase); //ajoute la case au monde
            }

        }
    }

    /**
     *
     * @param tailleX
     */
    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    /**
     * 
     * @return
     */
    public int getTailleX() {
        return this.tailleX;
    }

    /**
     *
     * @param tailleY
     */
    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

    /**
     * 
     * @return
     */
    public int getTailleY() {
        return this.tailleY;
    }
    /**
     *
     * @return
     */
    public ArrayList<Case> getCases() {
        return cases;
    }
    /**
     *
     * @param cases
     */
    public void setCases(ArrayList<Case> cases) {
        this.cases = cases;
    }
    /**
     *
     * @return
     */
    public Case getCaseVideAliatoire() {
        Case caseTrouvee = null; //contient la case vide trouvée, ou null
        
        //On supose que l'on va toruvé une case vide, pour entré dans le while
        boolean caseVideTrouve = true; //true si on trouve une case vide, si non false

        while (caseTrouvee == null && caseVideTrouve)
        {
            caseVideTrouve = false; //au début Case vide pas encore trouvée
            Random alea = new Random();
            int minX = 1;
            int minY = 1;
            int posX = alea.nextInt(tailleX - minX + 1) + minX;
            int posY = alea.nextInt(tailleY - minY + 1) + minY;
            //Pour toutes les cases
            for (Case uneCase : cases)
            {
                //Si la case est vide
                if (uneCase.isVide())
                {
                    caseVideTrouve = true; //indique que une case vide est trouvée
                    //Si une la case est bien à la position trouvée aléatoirement
                    if (posX == uneCase.getPositionX() &&
                            posY == uneCase.getPositionY())
                    {
                        return uneCase; //la case est retenue
                    }
                     else {
                     
                     }
                }

            } 
        }
        return caseTrouvee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
