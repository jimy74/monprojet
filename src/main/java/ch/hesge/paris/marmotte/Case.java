/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class Case extends JButton{
    private int positionX;
    private int positionY;
    private boolean vide;
    
    /**
     *
     * @param positionX
     * @param positionY
     */
    public Case(int positionX,int positionY) {
        super(new ImageIcon(Case.class.getClassLoader().getResource("TextureHerbePetite.jpg")));
        this.positionX = positionX;
        this.positionY = positionY;
        this.vide = true;
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setBorder(null);
    }
    
    /**
     *
     * @return
     */
    public int getPositionY() {
        return positionY;
    }
    
    /**
     * 
     * @return
     */
    public int getPositionX(){
        return positionX;
    }
    
    /**
     *
     * @return
     */
    public boolean isVide(){
        return vide;
    }
    
    /**
     *
     * @param vide
     */
    public void setVide(boolean vide){
        if (vide)
        {
            this.setIcon(new ImageIcon(Case.class.getClassLoader().getResource("TextureHerbePetite.jpg")));
        } else {
             this.setIcon(new ImageIcon(Case.class.getClassLoader().getResource("ImageMarmotte1Point.png")));
        }
        this.vide = vide;
    }
}
