/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.util.Random;
import java.util.TimerTask;
import javax.swing.SwingUtilities;

/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class JeuMarmotteHunter {

    private final Parametres param;
    private final TimerPerso timer;

    public JeuMarmotteHunter(Parametres param, TimerPerso timer) {
        this.param = param;
        this.timer = timer; 
        lancerTimer(timer);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parametres p = new Parametres();
        JeuMarmotteHunter jeu = new JeuMarmotteHunter(p,
                new TimerPerso(new Monde(p.getMondeTailleX(), p.getMondeTailleY()), p.getVitesseDifficulteEmperique(), p.getVitesseDifficulte()));
    }

    public void lancerTimer(TimerPerso timer) {   
        //Définit une action Ã  répéter par le timer
        TimerTask actionARepetee = new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    ajouterEtDeplacerMarmotteAlea(timer);
                });

            }
        };
        
        //Fait répéter l'action par le timer
        timer.scheduleAtFixedRate(actionARepetee, (long) timer.getDifficulteEmperique(), timer.getTemps());
    }

    public void ajouterEtDeplacerMarmotteAlea(TimerPerso p_timer) {
        Case caseAlea = p_timer.getMonde().getCaseVideAliatoire(new Random());
        if (caseAlea != null) {
            p_timer.getMarmottes().add(new Marmotte(param.getPvMarmotte(), caseAlea));
        } else {
            param.reduirePoint(1); 
            testFin(param.getScore());
        }
        p_timer.deplacerMarmottes(new Outil(), p_timer.getMonde());
        p_timer.afficherTemps();
    }

    public void testFin(int score) {
        //si le le score peut être réduit
        if (score < 1) {
            timer.afficherTemps();
            timer.cancel();
        }
    }

    //à utiliser seulement pour les Test
    public Parametres getParametres() {
        return param;
    }

    //à utiliser seulement pour les Test
    public TimerPerso getTimer() {
        return timer;
    }

    //astuce pour aller plus vite, à utiliser seulement pour les Test
    public Monde getMonde() {
        return timer.getMonde();
    }

}
