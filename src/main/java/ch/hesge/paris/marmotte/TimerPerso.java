/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class TimerPerso extends Timer {

    private double difficulteEmperique; //force de réduction du temps de rappel
    private int temps; //est le temps de rappel du timer
    private Monde monde;//monde principale, qui connait les cases
    private ArrayList<Marmotte> marmottes; //les marmottes, qui connaissent leurs cases
    private boolean marche = false;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd MM yyyy");
    Calendar calendrierStart = new GregorianCalendar();
    Date dateDebut = new Date();

    /**
     *
     * @return
     */
    public Monde getMonde() {
        return monde;
    }

    /**
     *
     * @return
     */
    public ArrayList<Marmotte> getMarmottes() {
        return marmottes;
    }

    /**
     *
     * @param difficulteEmperique
     * @param temps
     */
    public TimerPerso(double difficulteEmperique, int temps) {
        this.difficulteEmperique = difficulteEmperique;
        this.temps = temps;
        marche = true;
        marmottes = new ArrayList<Marmotte>();
    }

    /**
     *
     * @return
     */
    public int getTemps() {
        return temps;
    }

    /**
     *
     * @return
     */
    public void setMonde(Monde monde) {
        this.monde = monde;
    }

    /**
     *
     * @param temps
     */
    public void setTemps(int temps) {
        this.temps = temps;
    }

    /**
     *
     * @return
     */
    public double getDifficulteEmperique() {
        return difficulteEmperique;
    }

    /**
     *
     * @param difficulteEmperique
     */
    public void setDifficulteEmperique(double difficulteEmperique) {
        this.difficulteEmperique = difficulteEmperique;
    }

    /**
     *
     */
    public void printMonde() {

    }

    @Override
    public void cancel() {
        super.cancel();
        marche = false;
    }

    public Boolean isMarche() {
        return marche;
    }

    /**
     *
     */
    public void afficherScore() {

    }

    /**
     *
     */
    public void afficherTemps() {
        /**
         * Date du jour
         */
        Date dateActuelle = new Date();

        long difference = (dateActuelle.getTime() - dateDebut.getTime()) / (1000);
        monde.setLblTemps(difference + " secondes");
    }

    public void deplacerMarmottes() {
        //Pour toutes els marmottes
        for (Marmotte marmotte : marmottes) {
            Boolean marmotteDeplacee = false;
            Case caseActuelle = marmotte.getMaCase();

            ArrayList<Case> cases = monde.getCases();
            for (Case caseTest : cases) {
                if (!marmotteDeplacee) {
                    //si une marmotte peut se déplacer verticalement ou horizontalement
                    if (caseTest.getPositionX() == caseActuelle.getPositionX() - 1
                            || caseTest.getPositionX() == caseActuelle.getPositionX() + 1
                            || caseTest.getPositionX() == caseActuelle.getPositionY() - 1
                            || caseTest.getPositionX() == caseActuelle.getPositionY() + 1) {
                        if (caseTest.isVide()) {
                            marmotte.setMaCase(caseTest);
                            marmotteDeplacee = true;

                        }
                    }
                }

            }

        }
    }
}
