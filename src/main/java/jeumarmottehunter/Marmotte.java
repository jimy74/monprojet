/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumarmottehunter;

import java.io.File;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author DA_SAUDE_DAVID-ESIG
 */
public class Marmotte 
{
    
    private static final String LOCATION_IMG_MARMOTTE_1POINT = "src/main/resources/img/ImageMarmotte1Point.png";
    
    
    private int pv;
    private Case maCase;

    /**
     * 
     * @param pv
     */
    public Marmotte(int pv,Case saCase) {
        this.pv = pv;
        System.out.println(JeuMarmotteHunter.getProjetPath() + LOCATION_IMG_MARMOTTE_1POINT);
        saCase.setIcon(new ImageIcon(JeuMarmotteHunter.getProjetPath() + LOCATION_IMG_MARMOTTE_1POINT)); //met une image de marmotte
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
