/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class JeuMarmotteHunter {

    private static Parametres param = new Parametres();
    private static TimerPerso timer = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        param.charger();

        Monde monde = new Monde(param.getMondeTailleX(), param.getMondeTailleY());

        timer = new TimerPerso(param.getVitesseDifficulteEmperique(), param.getVitesseDifficulte());

        //Instancie le timer
        timer.setMonde(monde);

        //Définit une action à répéter par le timer
        TimerTask actionARepetee = new TimerTask() {
            @Override
            public void run() {
                ajouterOuDeplacerMarmotteAlea();
            }
        };

        //Fait répéter l'action par le timer
        timer.scheduleAtFixedRate(actionARepetee, (long) timer.getDifficulteEmperique(), timer.getTemps());
    }

    private static void ajouterOuDeplacerMarmotteAlea() {
        Monde monde = timer.getMonde();
        Case caseAlea = monde.getCaseVideAliatoire();
        if (caseAlea != null) {
            new Marmotte(param.getPvMarmotte(), caseAlea);
        } else {
            perdUnPoint();
            timer.deplacerMarmottes();
        }
        timer.afficherTemps();
    }

    public static void perdUnPoint() {
        //toutes les cases sont occupèe, on perd un point
        int score = param.getScore();
        //si le le score peut être réduit
        if (score - 1 > 0) {
            param.setScore(score - 1); //réduit le score de 1
        } //si le score est épuisé
        else {
            timer.afficherTemps();
            timer.cancel();
        }
    }

}
