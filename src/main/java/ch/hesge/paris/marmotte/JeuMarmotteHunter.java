/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.util.TimerTask;
import javax.swing.SwingUtilities;

/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class JeuMarmotteHunter {

    private Parametres param = new Parametres();
    private TimerPerso timer = null;
    private Monde monde = null;

    public JeuMarmotteHunter() {
        param.charger();

        monde = new Monde(param.getMondeTailleX(), param.getMondeTailleY());
        lancerTimer();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new JeuMarmotteHunter();
    }

    public void lancerTimer() {
        timer = new TimerPerso(param.getVitesseDifficulteEmperique(), param.getVitesseDifficulte());

        //Instancie le timer
        timer.setMonde(monde);

        //Définit une action Ã  répéter par le timer
        TimerTask actionARepetee = new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        ajouterEtDeplacerMarmotteAlea();
                    }
                });

            }
        };

        //Fait répéter l'action par le timer
        timer.scheduleAtFixedRate(actionARepetee, (long) timer.getDifficulteEmperique(), timer.getTemps());
    }

    public void ajouterEtDeplacerMarmotteAlea() {
        Case caseAlea = timer.getMonde().getCaseVideAliatoire();
        if (caseAlea != null) {
            timer.getMarmottes().add(new Marmotte(param.getPvMarmotte(), caseAlea));
        } else {
            param.setScore(perdUnPoint(param.getScore()));
        }
        timer.deplacerMarmottes();
        timer.afficherTemps();
    }

    public int perdUnPoint(int score) {
        score--;
        //si le le score peut être réduit
        if (score < 1) {
            timer.afficherTemps();
            timer.cancel();
            return 0;
        }
        return score;
    }

    //à utiliser seulement pour les Test
    public Parametres getParametres() {
        return param;
    }

    //à utiliser seulement pour les Test
    public TimerPerso getTimer() {
        return timer;
    }

    //à utiliser seulement pour les Test
    public Monde getMonde() {
        return monde;
    }

}
