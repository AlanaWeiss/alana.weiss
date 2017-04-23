

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VestirArmaduraTest
{
   @Test 
   public void vestirArmaduraVesteArmadura()throws Exception{
    Saint hyoga = new BronzeSaint("Hyoga","Cisne");
    Movimento movimento = new VestirArmadura(hyoga);
    movimento.executar();
    assertEquals(true,hyoga.getArmaduraVestida());
    
    }
}
