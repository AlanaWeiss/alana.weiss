

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ConstelacaoTest
{
    @Test
    public void adicionar1Golpe(){
        Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        gemeos.adicionarGolpe(outraDimensao);
        ArrayList<Golpe> golpes = new ArrayList<>();
        golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(1, golpes.size());
    }
    
    @Test
    public void adicionar2Golpes(){
          Constelacao gemeos = new Constelacao("Gemeos");
        Golpe outraDimensao = new Golpe("Outra Dimensao", 10);
        Golpe explosao = new Golpe("Explosao Galactica", 10);
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosao);
        ArrayList<Golpe> golpes = new ArrayList<>();
        golpes = gemeos.getGolpes();
        assertEquals(outraDimensao, golpes.get(0));
        assertEquals(explosao, golpes.get(1));
        assertEquals(2, golpes.size());
    }
    
    /*@Test
    public void adicionar3Golpes(){
    
    }
    
    @Test
    public void adicionar4Golpes(){
    
    }*/
}
