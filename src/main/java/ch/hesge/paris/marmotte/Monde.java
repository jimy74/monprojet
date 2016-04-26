package ch.hesge.paris.marmotte;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
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
public class Monde extends JFrame implements ActionListener{

//Déclaration des attributs
    //Tableau de cases
    private ArrayList<Case> cases = new ArrayList<Case>(); //avec instanciation direct pour ne pas le faire avant utilisation

    private int tailleX;
    private int tailleY;
    private JPanel zoneAffichage = new JPanel();;
    private JPanel zoneJeu = new JPanel();;
    private Label lblTemps = new Label("Temps : 0 seconde");

    //Constructeur
    public Monde(int tailleX, int tailleY) {
        super("Marmotte Hunter");  //met le titre de la fenêtre
        this.tailleX = tailleX;
        this.tailleY = tailleY;	
        initConfigForm();
        zoneAffichage.setLayout(new GridLayout(1, 3));       
        zoneAffichage.add(lblTemps);
        add("North",zoneAffichage);
        zoneJeu.setLayout(new GridLayout(tailleX, tailleY));
        add("Center",zoneJeu);
        afficherCases();
        afficherForm();
    }
    public void initConfigForm(){
                setDefaultCloseOperation(EXIT_ON_CLOSE);      
        setResizable(false);  
        setLayout(new BorderLayout ());
    }

    private void afficherCases(){
        //pour toutes les colonnes
        for (int y = 1; y <= tailleY; y++) {
            //pour toutes les lignes 
            for (int x = 1; x <= tailleX; x++) {
                Case nouvelleCase = new Case(x, y);
                cases.add(nouvelleCase); //ajoute la nouvelle case dans la liste de cases
                nouvelleCase.addActionListener(this); //lie la gestion d'événement au monde
                zoneJeu.add(nouvelleCase); //ajoute la case au monde
            }

        }        
    }
    private void afficherForm(){
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
    
    public void setLblTemps(String temps){
        lblTemps.setText("Temps : " + temps);
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
     * Doit impérativement trouver une case aléatoirement
     * @return
     */
    public Case getCaseVideAliatoire() {      
        boolean caseVideTrouve = false; 

        while (!caseVideTrouve)
        {
            Random alea = new Random();
            for (Case uneCase : cases)
            {
                if (uneCase.isVide())
                {
                    //Si la case est bien Ã  la position trouvée aléatoirement
                    if (alea.nextInt(tailleX) + 1 == uneCase.getPositionX() && alea.nextInt(tailleY) + 1 == uneCase.getPositionY()) {
                        caseVideTrouve = true; 
                        return uneCase; //la case est retenue
                    }
                }
            } 
        }
        return null;
    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println("gestion du click ... à développer");
    }
}
