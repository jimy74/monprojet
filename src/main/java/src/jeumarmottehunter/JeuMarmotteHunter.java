/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumarmottehunter;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;

/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class JeuMarmotteHunter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		System.out.println("modification test pour GIT");
		System.out.println("modification pour binome par 'Patrick'");
        // TODO code application logic here

        //Instanciation des paramètres
        final Parametres param = new Parametres();
        
        //Déclaration des variables
        
        int vitesseDifficulte;
        int vitesseDifficulteEmperique;
        int pvMarmotte;
        int degat;
        int mondeTailleX;
        int mondeTailleY;
        
        File fichierIniConfig = param.getFichierIni();
        if (fichierIniConfig != null) {
            param.lireFichierIni(fichierIniConfig);
            vitesseDifficulte = 1000;
            vitesseDifficulteEmperique = 0;
            pvMarmotte = 1;
            degat = 1;
            mondeTailleX = 3;
            mondeTailleY = 3;
        } else {
            //définit les paramètres
            //charge l'heure actuel (à ajouter !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!)
            vitesseDifficulte = 1000;
            vitesseDifficulteEmperique = 0;
            pvMarmotte = 1;
            degat = 1;
            mondeTailleX = 3;
            mondeTailleY = 3;

        }

        //passe les paramètres à l'objet paramètre
        param.setMondeTailleX(mondeTailleX);
        param.setMondeTailleY(mondeTailleY);
        param.setPvMarmotte(pvMarmotte);
        param.setVitesseDifficulte(vitesseDifficulte);
        param.setVitesseDifficulteEmperique(vitesseDifficulteEmperique);
        param.setDegat(degat);

        //chargement de l'heure
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd MM yyyy");
        Calendar calendrierStart = new GregorianCalendar();

        Date dateDebut = new Date();

        //Instancie le monde
        Monde monde = new Monde(param.getMondeTailleX(), param.getMondeTailleY());
        monde.pack();
        monde.setLocationRelativeTo(null);
        monde.setVisible(true);

        //Instancie le timer
        final TimerPerso timer = new TimerPerso(param.getVitesseDifficulteEmperique(), param.getVitesseDifficulte());
        timer.setMonde(monde);
        //Définit une action à répéter par le timer
        TimerTask actionARepetee = new TimerTask() {
            @Override
            public void run() {
                //Récupère le monde
                Monde monde = timer.getMonde();

                //Récupère une case vide aléatoire **ou** null
                Case caseAlea = monde.getCaseVideAliatoire();
                
                //Si la case est bien trouvée
                if (caseAlea != null)
                {
                    //Pour debug: affiche la case
                    System.out.println(caseAlea);

                    //Crée une marmotte dans cette case
                    Marmotte nouvelleMarmotte = new Marmotte(param.getPvMarmotte(),caseAlea);
                } else {

                    //toutes les cases sont occupèe, on perd un point
                    int score = param.getScore();
                    //si le le score peut être réduit
                    if (score - 1 > 0)
                    {
                        param.setScore(score - 1); //réduit le score de 1
                    }
                    //si le score est épuisé
                    else
                    {
                        timer.afficherTemps();
                        timer.cancel();
                    }

                    //déplacement des marmottes
                    timer.deplacerMarmottes();

                }


                //Affiche le temps du jeu
                timer.afficherTemps();
            }
        };

        //Fait répéter l'action par le timer
        timer.scheduleAtFixedRate(actionARepetee, (long) timer.getDifficulteEmperique(), timer.getTemps());
    }

}
