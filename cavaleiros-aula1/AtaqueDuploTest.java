import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest{
    @Test
    public void ataqueDuploSemArmadura() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));

        Movimento ataqueDuplo = new AtaqueDuplo(shiryu, misty);
        ataqueDuplo.executar(); 

        if (shiryu.getVida() == 100) {
            assertEquals(100, shiryu.getVida(), 0.01);
            assertEquals(80.0, misty.getVida(), 0.01);
        } else {
            assertEquals(95.0, shiryu.getVida(), 0.01);
            assertEquals(90.0, misty.getVida(), 0.01);
        }
    }
    
      @Test
    public void ataqueDuploComArmadura() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        shiryu.vestirArmadura();
        
        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Golpe do Lagarto", 10));

        Movimento ataqueDuplo = new AtaqueDuplo(shiryu, misty);
        ataqueDuplo.executar(); 

        if (shiryu.getVida() == 100) {
            assertEquals(100, shiryu.getVida(), 0.01);
            assertEquals(60.0, misty.getVida(), 0.01);
        } else {
            assertEquals(95.0, shiryu.getVida(), 0.01);
            assertEquals(90.0, misty.getVida(), 0.01);
        }
    }
}
