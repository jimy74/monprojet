/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

/**
 *
 * @author DA_SAUDE_DAVID-ESIG
 */
public class Marmotte {

    private int pv;
    private Case maCase;

    /**
     *
     * @param pv
     * @param saCase
     */
    public Marmotte(int pv, Case saCase) {
        this.pv = pv;
        this.maCase = saCase;                
        maCase.setVide(false);
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
        this.maCase.setVide(true);
        this.maCase = maCase;                
        maCase.setVide(false);
    }

    /**
     *
     * @return
     */
    public Case getMaCase() {
        return maCase;
    }
}
