import java.util.ArrayList;
public class ListaSaints{
    ArrayList<Saint> saints = new ArrayList<>();
    private int indice;
    
    public void adicionar(Saint saint){
        saints.add(saint);
    }
     
    public ArrayList todos(){
        return saints;
    }
    
    public Saint get(int indice){
        return saints.get(indice);
    }
       
    public void remover(Saint saint){
       // int i = saints.indexOf(saint);
       // saints.remove(i);
        saints.remove(saint);
    }
    
    public Saint buscaPorNome(String s){
           for(int  i = 0; i<saints.size();i++){
            Saint test = saints.get(i);
            if (test.getSaint().equals(s)) {
                return test;   
            }
        }
         return null;
    }
    
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
        ArrayList<Saint> listaPorCategoria = new ArrayList<>();
        for (int i = 0; i<saints.size();i++){
            Saint test = saints.get(i);
            if(test.getCategoriaArmadura() == categoria.getValor()) listaPorCategoria.add(test);
        }
        return listaPorCategoria;
    } 
    
    public ArrayList<Saint> buscarPorStatus(Status status){
        ArrayList<Saint> listaPorStatus = new ArrayList<>();
        for (int i = 0; i<saints.size();i++){
            Saint test = saints.get(i);
            if(test.getStatus().equals(status)) listaPorStatus.add(test);
        }
        return listaPorStatus;
    } 
    
    public Saint getSaintMaiorVida(){
        double vida = 0.0;
        Saint saint=null;
        for (int x = 0; x<saints.size();x++){
            Saint test = saints.get(x);
            if (test.getVida()>vida){
                saint = test;
                vida=test.getVida();
            }
        }
        return saint;
    }
    public Saint getSaintMenorVida(){
        double vida = 100.0;
        Saint saint = null;
        for (int x = 0; x<saints.size();x++){
            Saint test = saints.get(x);
            if (test.getVida()<vida){
                saint = test;   
                vida=test.getVida();
            }
        }
        return saint;
    }
}
