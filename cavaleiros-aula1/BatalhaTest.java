

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest
{
    @Test
    public void BatalhaPrataEBronze()
    {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.PRATA));
        Saint hyoga = new Saint("Hyoga", new Armadura("Capricornio", Categoria.BRONZE));
        Batalha batalha = new Batalha (dante,hyoga);
        batalha.iniciar();
        assertEquals(100,dante.getVida(),0.01);
        assertEquals(90,hyoga.getVida(),0.01);
    }
    
    @Test
    public void BatalhaPrataEPrata()
    {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.PRATA));
        Saint hyoga = new Saint("Hyoga", new Armadura("Capricornio", Categoria.PRATA));
        Batalha batalha = new Batalha (dante,hyoga);
        batalha.iniciar();
        assertEquals(100,dante.getVida(),0.01);
        assertEquals(90,hyoga.getVida(),0.01);
    }
    
    @Test
    public void BatalhaBronzeEPrata()
    {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        Saint hyoga = new Saint("Hyoga", new Armadura("Capricornio", Categoria.PRATA));
        Batalha batalha = new Batalha (dante,hyoga);
        batalha.iniciar();
        assertEquals(90,dante.getVida(),0.01);
        assertEquals(100,hyoga.getVida(),0.01);
    }
}