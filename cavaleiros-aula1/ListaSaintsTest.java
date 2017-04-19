import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest
{
    @Test
    public void testarAddSaint() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        
        ListaSaints lista = new ListaSaints();
        lista.adicionar(hyoga);
        
        assertEquals(hyoga, lista.get(0));
    }
    @Test
    public void removerSaintRemoveSaint() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        Saint lala = new Saint("lala", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        ListaSaints lista = new ListaSaints();
        lista.adicionar(hyoga);
        lista.adicionar(lala);
        lista.remover(hyoga);
        assertEquals(lala, lista.get(0));
    }
    @Test
    public void getIndiceRetornaOSaintNoIndice() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        Saint lala = new Saint("lala", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        ListaSaints lista = new ListaSaints();
        lista.adicionar(hyoga);
        lista.adicionar(lala);
        Saint testeSaint = lista.get(0);
        assertEquals(testeSaint, lista.get(0));
    }
	
	@Test public void buscarPorNomeBuscaPorNome() throws Exception{
	ListaSaints lista = new ListaSaints();
	Saint lala = new Saint("lala", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
	lista.adicionar(lala);
	assertEquals(lala, lista.buscaPorNome("lala"));
	}
	 
	@Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        ArrayList<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
 	@Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(misty, listaSaints.getSaintMaiorVida());
    }
    
    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint maiorVida = listaSaints.getSaintMaiorVida();
        assertNull(maiorVida);
    }
 	@Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }	
}
