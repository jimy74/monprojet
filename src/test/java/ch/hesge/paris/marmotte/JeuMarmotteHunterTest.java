package ch.hesge.paris.marmotte;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Assert;
import org.junit.Ignore;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import static org.mockito.Mockito.*;

public class JeuMarmotteHunterTest {

    private JeuMarmotteHunter jeu;
    private Parametres p;

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
    
    // Exemple fait avec Nicolas Frankel lors du cours
    @Test
    public void ajouterEtDeplacerMarmotteAlea_reduit_le_score_si_caseAlea_null() {
        
        TimerPerso timer = mock(TimerPerso.class);
        Monde monde = mock(Monde.class);
        
        when(timer.getMonde()).thenReturn(monde);
        when(monde.getCaseVideAliatoire(new Random())).thenReturn(null);      
        
        int ancienScore = p.getScore();
        jeu.ajouterEtDeplacerMarmotteAlea(timer); 
        int nouveauScore = p.getScore();
        
        Assert.assertTrue(ancienScore > nouveauScore);
    }
    
    @Test
    public void ajouterEtDeplacerMarmotteAlea_ne_change_pas_le_score_si_caseAlea_trouvee() {
        
        TimerPerso timer = mock(TimerPerso.class);
        Monde monde = mock(Monde.class);
        
        when(timer.getMonde()).thenReturn(monde);
        when(monde.getCaseVideAliatoire(any(Random.class))).thenReturn(new Case(1,1));      
       
        int ancienScore = p.getScore();
        jeu.ajouterEtDeplacerMarmotteAlea(timer);       
        int nouveauScore = p.getScore();
       
        Assert.assertEquals(ancienScore,nouveauScore);
    }
    
    @Test
     public void ajouterEtDeplacerMarmotteAlea_ajoute_une_marmotte_si_caseAlea_trouve() {
        
        TimerPerso timer = mock(TimerPerso.class);
        Monde monde = mock(Monde.class);
        
        when(timer.getMonde()).thenReturn(monde);
        when(monde.getCaseVideAliatoire(any(Random.class))).thenReturn(new Case(1, 1));      
        
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
        when(monde.getCaseVideAliatoire(any(Random.class))).thenReturn(null);      
        
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
      
       @Test
      public void instancer_le_jeu_lance_le_timer() {
             Assert.assertTrue(jeu.getTimer().isMarche());
    }      
}
