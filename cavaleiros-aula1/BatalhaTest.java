

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void BatalhaPrataEBronze()throws Exception {
    
        Saint dante = new SilverSaint("Dante","Cisne");
        Saint hyoga = new BronzeSaint("Hyoga", "Capricornio");
        Batalha batalha = new Batalha (dante,hyoga);
        batalha.iniciar();
        assertEquals(100,dante.getVida(),0.01);
        assertEquals(90,hyoga.getVida(),0.01);
    }
    
    @Test
    public void BatalhaPrataEPrata()throws Exception {
    
        Saint dante = new SilverSaint("Dante", "Cisne");
        Saint hyoga = new SilverSaint("Hyoga","Capricornio");
        Batalha batalha = new Batalha (dante,hyoga);
        batalha.iniciar();
        assertEquals(100,dante.getVida(),0.01);
        assertEquals(90,hyoga.getVida(),0.01);
    }
    
    @Test
    public void BatalhaBronzeEPrata() throws Exception {
        Constelacao virgem = new Constelacao("Virgem");
        Constelacao sagitario = new Constelacao("Sagitário");
        Saint shiryu = new BronzeSaint("shiryu", virgem.getNome());
        Saint ikki = new SilverSaint("ikki", sagitario.getNome());
        Batalha batalha = new Batalha(shiryu, ikki);
        batalha.iniciar();
        assertEquals(90.0, shiryu.getVida(), 0.1);
        assertEquals(100.0, ikki.getVida(), 0.1);
    }
}