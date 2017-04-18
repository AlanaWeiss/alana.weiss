import java.util.ArrayList;

public class Constelacao {
    private String nome;
    //private Golpe[] golpes = new Golpe[3];
    ArrayList<Golpe> golpes = new ArrayList<>();
    private int ultimaPosicaoPreenchida = 0;
 
    public Constelacao(String nome){
        this.nome=nome;
    }
    
    public void adicionarGolpe(Golpe golpe){
        golpes.add(golpe); //golpeS = array
                           //golpE = parametro        
    }
    
    public ArrayList getGolpes(){
        return golpes;
    }
    
    public String getNome() {
        return this.nome;
     }
    
}
 