/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumarmottehunter;

import java.util.*;
import java.io.*;
/**
 *
 * @author ANFELONI-KYLE-ESIG
 */
class readIni {
  public static void main(String args[]) {
    readIni ini = new readIni();
    ini.doit();
    }

  public void doit() {
    try{
      Properties p = new Properties();
      p.load(new FileInputStream("user.ini"));
      System.out.println("user = " + p.getProperty("DBuser"));
      System.out.println("password = " + p.getProperty("DBpassword"));
      System.out.println("location = " + p.getProperty("DBlocation"));
      p.list(System.out);
      }
    catch (Exception e) {
      System.out.println(e);
      }
    }
}

/**
 *
 * @author jimmy
 */
public class Parametres {
    
 int vitesseDifficulte;
 int vitesseDifficulteEmperique;
 int pvMarmotte;
 int degat;
 int score;
 int mondeTailleX;
 int mondeTailleY;
 
 

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
 
    /**
     * 
     * @return
     */
    public File getFichierIni(){
        return null;
    }
    
    /**
     *
     * @param ini
     */
    public void lireFichierIni(File ini){
    
    }
           
 
}
