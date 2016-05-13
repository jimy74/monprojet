package ch.hesge.paris.marmotte;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Ignore;
import org.mockito.Mockito;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertNotNull;

public class JeuMarmotteHunterTest {

    private JeuMarmotteHunter jeu;
    private Parametres p;

    @BeforeClass
    public void setUpGlobal() {

    }

    @BeforeMethod
    public void setUp() {
        p = new Parametres();
        jeu = new JeuMarmotteHunter(p,
                new TimerPerso(new Monde(p.getMondeTailleX(), p.getMondeTailleY()),
                        p.getVitesseDifficulteEmperique(),
                        p.getVitesseDifficulte()
                )
        );
    }

/* ****************************************************************************************************
    Test de ajouterEtDeplacerMarmotteAlea() 
**************************************************************************************************** */
    
    // /!\ tests d'intégrations MAL ECRIT , Voir prochain cours
    @Ignore
    @Test
    public void ajouterEtDeplacerMarmotteAlea_deplace_une_marmotte_si_place() {
        
        int nbMarmottesAvant = jeu.getTimer().getMarmottes().size();
        int nbMarmottesMax = jeu.getMonde().getTailleX() * jeu.getMonde().getTailleY();

        ArrayList<String> alPositionsAvant = new ArrayList<String>();
        for (Marmotte m : jeu.getTimer().getMarmottes()) {
            alPositionsAvant.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }
        jeu.ajouterEtDeplacerMarmotteAlea(jeu.getTimer());
        ArrayList<String> alPositionsApres = new ArrayList<String>();
        for (Marmotte m : jeu.getTimer().getMarmottes()) {
            alPositionsApres.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }

        assertTrue(!alPositionsAvant.equals(alPositionsApres) || nbMarmottesAvant == nbMarmottesMax || nbMarmottesAvant <= 0);
                      

    }

    // /!\ tests d'intégrations MAL ECRIT , Voir prochain cours
    @Ignore
    @Test
    public void ajouterEtDeplacerMarmotteAlea_reduit_score_si_plus_grand_que_0_et_monde_rempli() {

        int nbMarmottesAvant = jeu.getTimer().getMarmottes().size();
        int nbMarmottesMax = jeu.getMonde().getTailleX() * jeu.getMonde().getTailleY();

        int ancienScore = jeu.getParametres().getScore();

        jeu.ajouterEtDeplacerMarmotteAlea(jeu.getTimer());
        if (ancienScore > 0 && nbMarmottesAvant == nbMarmottesMax) {
            assertTrue(ancienScore < jeu.getParametres().getScore());
        }
    }     
    
    // Exemple fait avec Nicolas Frankel lors du cours
    @Test
    public void ajouterEtDeplacerMarmotteAlea_doit_modifier_score_si_caseAlea_null() {
        
        TimerPerso timer = mock(TimerPerso.class);
        Monde monde = mock(Monde.class);
        
        when(timer.getMonde()).thenReturn(monde);
        when(monde.getCaseVideAliatoire()).thenReturn(null);      
        
        int ancienScore = p.getScore();
        jeu.ajouterEtDeplacerMarmotteAlea(timer); 
        int nouveauScore = p.getScore();
        
        Assert.assertTrue(ancienScore > nouveauScore);
    }
    
    @Test
    public void ajouterEtDeplacerMarmotteAlea_ne_doit_pas_modifier_score_si_caseAlea_null() {
        
        TimerPerso timer = mock(TimerPerso.class);
        Monde monde = mock(Monde.class);
        
        when(timer.getMonde()).thenReturn(monde);
        when(monde.getCaseVideAliatoire()).thenReturn(new Case(1,1));      
        
        int ancienScore = p.getScore();
        jeu.ajouterEtDeplacerMarmotteAlea(timer); 
        int nouveauScore = p.getScore();
        
        Assert.assertTrue(ancienScore == nouveauScore);
    }
    
    @Test
     public void ajouterEtDeplacerMarmotteAlea_ajoute_une_marmotte_si_caseAlea_trouve() {
        
        TimerPerso timer = mock(TimerPerso.class);
        Monde monde = mock(Monde.class);
        
        when(timer.getMonde()).thenReturn(monde);
        when(monde.getCaseVideAliatoire()).thenReturn(new Case(1, 1));      
        
        int ancienNbMarmottes = timer.getMarmottes().size();
        jeu.ajouterEtDeplacerMarmotteAlea(timer); 
        int nouveauNbMarmottes = timer.getMarmottes().size();
        
        Assert.assertTrue(ancienNbMarmottes < nouveauNbMarmottes || !timer.isMarche());
    } 

     @Test
     public void ajouterEtDeplacerMarmotteAlea_ajoute_Pas_de_marmotte_si_caseAlea_null() {
        
        TimerPerso timer = mock(TimerPerso.class);
        Monde monde = mock(Monde.class);
        
        when(timer.getMonde()).thenReturn(monde);
        when(monde.getCaseVideAliatoire()).thenReturn(null);      
        
        int ancienNbMarmottes = timer.getMarmottes().size();
        jeu.ajouterEtDeplacerMarmotteAlea(timer); 
        int nouveauNbMarmottes = timer.getMarmottes().size();
        
        Assert.assertTrue(ancienNbMarmottes == nouveauNbMarmottes);
    }  
     
/* ****************************************************************************************************
    Test de testFin() 
**************************************************************************************************** */
    
     @Test
      public void testFin_arrete_le_jeu__si_score_plus_petit_que_0() {
        
        jeu.testFin(-1);      
        Assert.assertFalse(jeu.getTimer().isMarche());
    }  
      @Test
      public void testFin_arrete_si_score_egale_0() {
        
        jeu.testFin(0);      
        Assert.assertFalse(jeu.getTimer().isMarche());
    }   
      
      @Test
      public void testFin_arrete_pas_le_jeu_si_score_plus_grand_que_0() {
        
        jeu.testFin(1);      
        Assert.assertTrue(jeu.getTimer().isMarche());
    }       
}
