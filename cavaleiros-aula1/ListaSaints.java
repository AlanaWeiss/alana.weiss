import java.util.ArrayList;
public class ListaSaints{
    ArrayList<Saint> saints = new ArrayList<>();
    private int indice;
    
    public void adicionar(Saint saint){
        saints.add(saint);
    }
    
    public void adicionarSaint(Saint saint){
        saints.add(saint); //golpeS = array
                           //golpE = parametro        
    }
     
    public ArrayList todos(){
        return saints;
    }
    
    public Saint get(int indice){
        return saints.get(indice);
    }
       
    public void remover(Saint saint){
        int i = saints.indexOf(saint);
        saints.remove(i);
    }
}
