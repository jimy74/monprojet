/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.util.TimerTask;

/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class JeuMarmotteHunter {

    private Parametres param = new Parametres();
    private TimerPerso timer = null;
    private Monde monde = null;

    public JeuMarmotteHunter(){
        param.charger();

        monde = new Monde(param.getMondeTailleX(), param.getMondeTailleY());     
        lancerTimer();        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JeuMarmotteHunter jeu = new JeuMarmotteHunter();
    }
    

    public void lancerTimer(){
        timer = new TimerPerso(param.getVitesseDifficulteEmperique(), param.getVitesseDifficulte());

        //Instancie le timer
        timer.setMonde(monde);

        //D�finit une action à r�p�ter par le timer
        TimerTask actionARepetee = new TimerTask() {
            @Override
            public void run() {
                ajouterOuDeplacerMarmotteAlea();
            }
        };

        //Fait r�p�ter l'action par le timer
        timer.scheduleAtFixedRate(actionARepetee, (long) timer.getDifficulteEmperique(), timer.getTemps());        
    }

        
    private void ajouterOuDeplacerMarmotteAlea() {
        Monde monde = timer.getMonde();
        Case caseAlea = monde.getCaseVideAliatoire();
        if (caseAlea != null) {
            new Marmotte(param.getPvMarmotte(), caseAlea);
        } else {
            param.setScore(perdUnPoint(param.getScore()));
            timer.deplacerMarmottes(); // A IMPLEMENTER
        }
        timer.afficherTemps();
    }

    public int perdUnPoint(int score) {
        //si le le score peut �tre r�duit
        if (score > 0) {
            return (score - 1); //r�duit le score de 1
        } //si le score est �puis�
        else {          
            timer.afficherTemps();
            timer.cancel();
            if (timer == null)
                System.out.println("ok");
            return score;
        }
    }
    
    //� utiliser seulement pour les Test
    public Parametres getParametres(){
        return param;
    }
    //� utiliser seulement pour les Test
    public TimerPerso getTimer(){
        return timer;
    }
        //� utiliser seulement pour les Test
    public Monde getMonde(){
        return monde;
    }

}
