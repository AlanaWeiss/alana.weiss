

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVEstida()throws Exception {
       //AAA
       //1. Arrange - Montagem dos dados de teste
       Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
       Saint milo = new Saint("Milo", escorpiao);
       //2. Act - Invocar a ação a ser testada
       milo.vestirArmadura(); 
       //3. Assert - Verificação dos resultados do teste
       boolean resultado = milo.getArmaduraVestida(); 
       assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida()throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado()throws Exception {
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Gênero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test 
    public void aoCriarSaintStatusEVivo()throws Exception {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(Status.VIVO, dante.getStatus());
    }
    
    @Test
    public void saintsNascemCom100DeVida()throws Exception {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(100.0, dante.getVida(),0.01);
    }
    
    @Test
    public void deveSerPossivelAlterarGenero()throws Exception {
        Saint jabu = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        jabu.setGenero(Gênero.MASCULINO);
        assertEquals(Gênero.MASCULINO, jabu.getGenero());
    }
    
    @Test
    public void perderDanoComValor10()throws Exception {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        dante.perderVida(10);
        assertEquals(90,dante.getVida(),0.01);
    }
    
    @Test
    public void perderDanoComValor100()throws Exception {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        dante.perderVida(100);
        assertEquals(0,dante.getVida(),0.01);
    }
    
    /*@Test
    /*public void perderDanoComValor1000()throws Exception {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        dante.perderVida(1000);
        assertEquals(-900,dante.getVida(),0.01);
    }*/
    
    /* @Test
    public void perderDanoComValorMenos1000()throws Exception {
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        dante.perderVida(-1000);
        assertEquals(1100,dante.getVida(),0.01);
    }*/
    
    @Test
    public void criarSaintNasceCom5SentidosDespertados()throws Exception {
        BronzeSaint dante = new BronzeSaint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(5, dante.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7Sentidos()throws Exception {
        GoldSaint dante = new GoldSaint("Dante", new Armadura("Virgem", Categoria.OURO));
        assertEquals(7, dante.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintPrataNasceCom6Sentidos()throws Exception {
        SilverSaint dante = new SilverSaint("Dante", new Armadura("Cisne", Categoria.PRATA));
        assertEquals(6, dante.getQtdSentidosDespertados());
    }
    @Test
    public void criarSaintBronzeNasceCom5Sentidos()throws Exception {
        BronzeSaint dante = new BronzeSaint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(5, dante.getQtdSentidosDespertados());
    }
}
