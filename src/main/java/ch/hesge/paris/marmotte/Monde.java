package ch.hesge.paris.marmotte;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PARIS_JIMMY-ESIG
 */
public class Monde extends FramePerso{

    //Constructeur
    public Monde(int tailleX, int tailleY) {
        super(tailleX, tailleY);  //met le titre de la fen�tre
    }


    public boolean toutesCasesPleines(){
        for (Case uneCase : getCases()){
            if (uneCase.isVide())
                return false;
        }
        return true;
        
                        
                    
    }
            
    /**
     * Doit imp�rativement trouver une case al�atoirement
     * @return
     */
    public Case getCaseVideAliatoire(Random alea) {    
        if (toutesCasesPleines())
            return null;
        
        while (true)
        {
            
            for (Case uneCase : getCases())
            {
                if (uneCase.isVide())
                {
                    //Si la case est bien à la position trouv�e al�atoirement
                    if (alea.nextInt(getTailleX()) + 1 == uneCase.getPositionX() && (alea.nextInt(getTailleY()) + 1 == uneCase.getPositionY())) {
                        return uneCase; //la case est retenue
                    }
                }
            } 
        }
    }

}
