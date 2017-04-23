

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest{
    
    @Test
    public void testarAtaqueComSaintOuroComArmadura()throws Exception{
        Saint camus = new GoldSaint("Camus","Aquário");
        Saint ikki = new BronzeSaint("Ikki","Fênix");
        Golpe execucao = new Golpe("Execução Aurora", 10);
        camus.vestirArmadura();
        camus.aprenderGolpe(execucao);
        Golpear golpear = new Golpear(camus, ikki);
        golpear.executar();
        assertEquals(60.0,ikki.getVida(),0.1);
    }

    @Test
    public void testarAtaqueComSaintOuroSemArmadura()throws Exception{
        Saint camus = new GoldSaint("Camus","Aquário");
        Saint ikki = new BronzeSaint("Ikki","Fênix");
        Golpe execucao = new Golpe("Execução Aurora", 10);
        camus.aprenderGolpe(execucao);
        Golpear golpear = new Golpear(camus, ikki);
        golpear.executar();
        assertEquals(90.0,ikki.getVida(),0.1);
    }
    
    @Test
    public void testarAtaqueComSaintPrataComArmadura()throws Exception{
        Saint babel = new SilverSaint("Babel","Centauro");
        Saint ikki = new BronzeSaint("Ikki","Fênix");
        Golpe chamas = new Golpe("Chamas de Babel", 10);
        babel.vestirArmadura();
        babel.aprenderGolpe(chamas);
        Golpear golpear = new Golpear(babel, ikki);
        golpear.executar();
        assertEquals(70.0,ikki.getVida(),0.1);
    }

    @Test
    public void testarAtaqueComSaintPrataSemArmadura()throws Exception{
        Saint babel = new SilverSaint("Babel","Centauro");
        Saint ikki = new BronzeSaint("Ikki","Fênix");
        Golpe chamas = new Golpe("Chamas de Babel", 10);
        babel.aprenderGolpe(chamas);
        Golpear golpear = new Golpear(babel, ikki);
        golpear.executar();
        assertEquals(90.0,ikki.getVida(),0.1);
    }
    
    @Test
    public void testarAtaqueComSaintBronzeComArmadura()throws Exception{
        Saint moses = new BronzeSaint("Moses","Baleia");
        Saint ikki = new BronzeSaint("Ikki","Fênix");
        Golpe forca = new Golpe("Força Explosiva", 10);
        moses.vestirArmadura();
        moses.aprenderGolpe(forca);
        Golpear golpear = new Golpear(moses, ikki);
        golpear.executar();
        assertEquals(80.0,ikki.getVida(),0.1);
    }

    @Test
    public void testarAtaqueComSaintBronzeSemArmadura()throws Exception{
        Saint babel = new BronzeSaint("Babel","Centauro");
        Saint ikki = new BronzeSaint("Ikki","Fênix");
        Golpe chamas = new Golpe("Chamas de Babel", 10);
        babel.aprenderGolpe(chamas);
        Golpear golpear = new Golpear(babel, ikki);
        golpear.executar();
        assertEquals(90.0,ikki.getVida(),0.1);
    }
}
