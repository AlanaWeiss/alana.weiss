import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SorteDoDiaTest {
    
    @Test
    public void sorteDoDiaTemMetadeDeChanceDeTerSorte(){
        Sorteador sorteador = new DadoFalso(6);
        SorteDoDia sorteDia = new SorteDoDia(sorteador);
        assertTrue(sorteDia.estouComSorte());
    }
    
    @Test
    public void sorteDoDiaTemMetadeDeChanceDeNaoTerSorte(){
        Sorteador sorteador = new DadoFalso(3);
        SorteDoDia sorteDia = new SorteDoDia(sorteador);
        assertFalse(sorteDia.estouComSorte());
    }
}
