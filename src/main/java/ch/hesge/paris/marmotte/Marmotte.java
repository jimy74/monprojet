/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import javax.swing.ImageIcon;

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
        saCase.setVide(false);
        this.maCase = saCase;
        putImgMarmotte();
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

    public void putImgMarmotte(){
        maCase.setIcon(new ImageIcon(Case.class.getClassLoader().getResource("ImageMarmotte1Point.png"))); //met une image de marmotte
    }
    /**
     *
     * @param maCase
     */
    public void setMaCase(Case maCase) {
        this.maCase.setVide(true);
        this.maCase = maCase;
        maCase.setVide(false);
        putImgMarmotte();
    }

    /**
     *
     * @return
     */
    public Case getMaCase() {
        return maCase;
    }
}
