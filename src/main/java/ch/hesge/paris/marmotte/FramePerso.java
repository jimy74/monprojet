package ch.hesge.paris.marmotte;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
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
public class FramePerso extends JFrame implements ActionListener{

//Déclaration des attributs
    //Tableau de cases
    private ArrayList<Case> cases = new ArrayList<Case>(); //avec instanciation direct pour ne pas le faire avant utilisation

    private int tailleX;
    private int tailleY;
    private JPanel zoneAffichage = new JPanel();
    private JPanel zoneJeu = new JPanel();
    private Label lblTemps = new Label("Temps : 0 seconde");

    //Constructeur
    public FramePerso(int tailleX, int tailleY) {
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

    private void afficherForm(){
        pack();
        setLocationRelativeTo(null);
        setVisible(true);        
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

    public void actionPerformed(ActionEvent ae) {
        System.out.println("gestion du click ... à développer");
    }
}
