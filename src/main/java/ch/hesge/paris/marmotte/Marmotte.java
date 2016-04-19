/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author DA_SAUDE_DAVID-ESIG
 */
public class Marmotte 
{
    private int pv;
    private Case maCase;

    /**
     * 
     * @param pv
     */
    public Marmotte(int pv,Case saCase) {
        this.pv = pv;
        saCase.setIcon(new ImageIcon(Case.class.getClassLoader().getResource("ImageMarmotte1Point.png"))); //met une image de marmotte
        saCase.setVide(false); //indique que la case n'est plus vide
        this.maCase = saCase;
    }
    
    /**
     *
     * @param pv
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     *
     * @return
     */
    public int getPv() {
        return pv;
    }

    /**
     *
     * @param maCase
     */
    public void setMaCase(Case maCase) {
        this.maCase = maCase;
    }

    /**
     *
     * @return
     */
    public Case getMaCase() {
        return maCase;
    }
}
