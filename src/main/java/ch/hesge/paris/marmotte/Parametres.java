/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.util.*;
import java.io.*;
/**
 *
 * @author ANFELONI-KYLE-ESIG
 *  support by JIMMY PARIS
 */
public class Parametres {
    
 private int vitesseDifficulte;
 private int vitesseDifficulteEmperique;
 private int pvMarmotte;
 private int degat;
 private int score;
 private int mondeTailleX;
 private int mondeTailleY;

    public Parametres() {
        charger();
    }
 
 
    public void charger(){
        setMondeTailleX(4);
        setMondeTailleY(4);
        setPvMarmotte(1);
        setVitesseDifficulte(1000);
        setVitesseDifficulteEmperique(0);
        setDegat(1);
        setScore(1);
    }
    
 /**
  *
  * @param vitesseDifficulte
  */
 public void setVitesseDifficulte(int vitesseDifficulte) {
        this.vitesseDifficulte = vitesseDifficulte;
    }

 /**
  *
  * @param vitesseDifficulteEmperique
  */
 public void setVitesseDifficulteEmperique(int vitesseDifficulteEmperique) {
        this.vitesseDifficulteEmperique = vitesseDifficulteEmperique;
    }

    /**
     *
     * @param pvMarmotte
     */
    public void setPvMarmotte(int pvMarmotte) {
        this.pvMarmotte = pvMarmotte;
    }

    /**
     *
     * @param degat
     */
    public void setDegat(int degat) {
        this.degat = degat;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @param mondeTailleX
     */
    public void setMondeTailleX(int mondeTailleX) {
        this.mondeTailleX = mondeTailleX;
    }

    /**
     *
     * @param mondeTailleY
     */
    public void setMondeTailleY(int mondeTailleY) {
        this.mondeTailleY = mondeTailleY;
    }

    /**
     *
     * @return
     */
    public int getVitesseDifficulte() {
        return vitesseDifficulte;
    }

    /**
     *
     * @return
     */
    public int getVitesseDifficulteEmperique() {
        return vitesseDifficulteEmperique;
    }

    /**
     *
     * @return
     */
    public int getPvMarmotte() {
        return pvMarmotte;
    }

    /**
     *
     * @return
     */
    public int getDegat() {
        return degat;
    }

    /**
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return
     */
    public int getMondeTailleX() {
        return mondeTailleX;
    }

    /**
     *
     * @return
     */
    public int getMondeTailleY() {
        return mondeTailleY;
    }        
 
}
