import java.util.Random;

public class DadoD6 implements Sorteador{

        public int sortear(){
            final Random random = new Random();
            int min = 1, max = 6;
            return random.nextInt(max - min + 1) + min;
        }
        
}
  
