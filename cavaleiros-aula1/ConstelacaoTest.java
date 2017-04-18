

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest
{
    @Test
    public void adicionar1Golpe(){
        Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        gemeos.adicionarGolpe(outraDimensao);
        Golpe[] golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes[0]);
        assertNull(golpes[1]);
        assertNull(golpes[1]);
    }
    
    @Test
    public void adicionar2Golpes(){
          Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        Golpe explosao = new Golpe("Explosao Galactica", 10);
        //gemeos.adicionarGolpe(new Golpe("Outra Dimensao", 10));
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosao);
        Golpe[] golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes[0]);
        assertEquals(explosao, golpes[1]);
        assertNull(golpes[2]);
    }
    
    @Test
    public void adicionar3Golpes(){
    
    }
    
    @Test
    public void adicionar4Golpes(){
    
    }
}
