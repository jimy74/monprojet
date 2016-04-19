package ch.hesge.paris.marmotte;

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
        
        afficherCases();
        afficherForm();

    }

    public void afficherCases(){
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
    public void afficherForm(){
        pack();
        setLocationRelativeTo(null);
        setVisible(true);        
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
        boolean caseVideTrouve = true; 

        while (caseVideTrouve)
        {
            caseVideTrouve = false; 
            Random alea = new Random();
            for (Case uneCase : cases)
            {
                if (uneCase.isVide())
                {
                    caseVideTrouve = true; 
                    //Si la case est bien à la position trouvée aléatoirement
                    if (alea.nextInt(tailleX) + 1 == uneCase.getPositionX() && alea.nextInt(tailleY) + 1 == uneCase.getPositionY())
                        return uneCase; //la case est retenue
                }
            } 
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
