

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void BatalhaPrataEBronze()throws Exception {
    
        Saint dante = new Saint("Dante", new Armadura(new Constelacao("Cisne"), Categoria.PRATA));
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Capricornio"), Categoria.BRONZE));
        Batalha batalha = new Batalha (dante,hyoga);
        batalha.iniciar();
        assertEquals(100,dante.getVida(),0.01);
        assertEquals(90,hyoga.getVida(),0.01);
    }
    
    @Test
    public void BatalhaPrataEPrata()throws Exception {
    
        Saint dante = new Saint("Dante", new Armadura(new Constelacao("Cisne"), Categoria.PRATA));
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Capricornio"), Categoria.PRATA));
        Batalha batalha = new Batalha (dante,hyoga);
        batalha.iniciar();
        assertEquals(100,dante.getVida(),0.01);
        assertEquals(90,hyoga.getVida(),0.01);
    }
    
    @Test
    public void BatalhaBronzeEPrata() throws Exception {
        Saint dante = new Saint("Dante", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Capricornio"), Categoria.PRATA));
        Batalha batalha = new Batalha (dante,hyoga);
        batalha.iniciar();
        assertEquals(90,dante.getVida(),0.01);
        assertEquals(100,hyoga.getVida(),0.01);
    }
}