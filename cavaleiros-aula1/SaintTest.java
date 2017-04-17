

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVEstida(){
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
    public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado(){
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Gênero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test 
    public void aoCriarSaintStatusEVivo(){
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(Status.VIVO, dante.getStatus());
    }
    
    @Test
    public void saintsNascemCom100DeVida(){
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(100.0, dante.getVida(),0.01);
    }
    
    @Test
    public void deveSerPossivelAlterarGenero(){
        Saint jabu = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        jabu.setGenero(Gênero.MASCULINO);
        assertEquals(Gênero.MASCULINO, jabu.getGenero());
    }
    
    @Test
    public void perderDanoComValor10(){
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        dante.perderVida(10);
        assertEquals(90,dante.getVida(),0.01);
    }
    
    @Test
    public void perderDanoComValor100(){
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        dante.perderVida(100);
        assertEquals(0,dante.getVida(),0.01);
    }
    
    @Test
    public void perderDanoComValor1000(){
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        dante.perderVida(1000);
        assertEquals(-900,dante.getVida(),0.01);
    }
    
     @Test
    public void perderDanoComValorMenos1000(){
        Saint dante = new Saint("Dante", new Armadura("Cisne", Categoria.BRONZE));
        dante.perderVida(-1000);
        assertEquals(1100,dante.getVida(),0.01);
    }
}
