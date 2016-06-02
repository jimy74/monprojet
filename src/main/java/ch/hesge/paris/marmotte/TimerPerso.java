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
    protected ArrayList<Marmotte> marmottes; //les marmottes, qui connaissent leurs cases
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
     * @param monde
     * @param difficulteEmperique
     * @param temps
     */
    public TimerPerso(Monde monde, double difficulteEmperique, int temps) {
        this.monde = monde;
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
    public void afficherTemps() {
        /**
         * Date du jour
         */
        Date dateActuelle = new Date();

        long difference = (dateActuelle.getTime() - dateDebut.getTime()) / (temps);
        monde.setLblTemps(difference + " secondes");
    }

    public void deplacerMarmottes(Outil o, Monde p_monde) {
        for (Marmotte marmotte : marmottes) {
            Case maCase = marmotte.getMaCase();
            ArrayList<Case> cases = p_monde.getCases();
            for (Case uneCase : cases) {
                //si marmotte à une case vide directement à proximité
                if (uneCase.isVide() && o.abs(o.soustraction(uneCase.getPositionX(),maCase.getPositionX())) == 1 && o.abs(o.soustraction(uneCase.getPositionY(),maCase.getPositionY())) == 1) {
                    marmotte.setMaCase(uneCase);
                }
            }
        }
    }
}
