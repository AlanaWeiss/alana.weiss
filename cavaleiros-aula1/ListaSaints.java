import java.util.ArrayList;
import java.util.stream.Collectors;
public class ListaSaints{
    ArrayList<Saint> saints = new ArrayList<>();
    private int indice;
    
    public void adicionar(Saint saint){
        this.saints.add(saint);
    }
     
    public ArrayList<Saint> todos(){
        return this.saints;
    }
    
    public Saint get(int indice){
        return this.saints.get(indice);
    }
       
    public void remover(Saint saint){
         this.saints.remove(saint);
    }
    
    public Saint buscaPorNome(String s){
           for(int  i = 0; i<saints.size();i++){
            Saint test = this.saints.get(i);
            if (test.getSaint().equals(s)) {
                return test;   
            }
        }
         return null;
        
    }
    
   public ArrayList<Saint> buscarPorCategoria(Categoria categoria) {
        return (ArrayList<Saint>)this.saints.stream()
            .filter(s -> s.getArmadura().getCat().equals(categoria))
            .collect(Collectors.toList());
    }
    
    public ArrayList<Saint> buscarPorStatus(Status status) {
        return (ArrayList<Saint>)this.saints.stream()
            .filter(s -> s.getStatus().equals(status))
            .collect(Collectors.toList());
    }
    
    public Saint getSaintMaiorVida(){
        double vida = 0.0;
        Saint saintMaior=null;
        
        if (saints.isEmpty()) {
            return null;
        }
        
        for (int x = 0; x<saints.size();x++){
            Saint test = saints.get(x);
            if (test.getVida()>vida){
                saintMaior = test;
                vida=test.getVida();
            }
        }
        return saintMaior;
    }

    public Saint getSaintMenorVida(){
        double vida = 100.0;
        Saint saint = null;
        
        if (saints.isEmpty()) {
            return null;
        }
        
        for (int x = 0; x<saints.size();x++){
            Saint test = saints.get(x);
            if (test.getVida()<vida){
                saint = test;   
                vida=test.getVida();
            }
        }
        return saint;
    }
    
    public void ordenar() {
        this.ordenar(TipoOrdenacao.ASCENDENTE);
    }   
    
    public void ordenar(TipoOrdenacao tipoOrdenacao) {
        /*
         * BubbleSort
         * Complexidade: O(n^2)
         * 
         * 
         *     [4] [3] [60] [17] [10]
         * i0: [3] [4] [17] [10] [60]
         * i1: [3] [4] [10] [17] [60]
         */
        boolean ascendente = tipoOrdenacao == TipoOrdenacao.ASCENDENTE;
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.saints.size() - 1; i++) {
                Saint atual = this.saints.get(i);
                Saint proximo = this.saints.get(i + 1);
                boolean precisaTrocar = 
                    ascendente ? atual.getVida() > proximo.getVida() :
                    atual.getVida() < proximo.getVida();

                if (precisaTrocar) {
                    this.saints.set(i, proximo);
                    this.saints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas); 
    }
    
       public ArrayList<Saint> unir(ListaSaints listaRecebida){
        ArrayList<Saint> nova = new ArrayList<>();
        ArrayList<Saint> arrayRecebido = listaRecebida.todos();
        nova = this.todos();
        nova.addAll(arrayRecebido);
        return nova;
    }
     
     public ArrayList<Saint> diff (ListaSaints recebido){
        ArrayList<Saint> saintsDiferentes = new ArrayList<>();
        ArrayList<Saint> arrayRecebido = recebido.todos();
        boolean diferentes = true;
        for(int i = 0; i<this.saints.size();i++){
            for(int x=0; x<arrayRecebido.size();x++){
                if (saints.get(i).equals(arrayRecebido.get(x))) diferentes = false;
            }
            if(diferentes) saintsDiferentes.add(saints.get(i));
        }
        return saintsDiferentes;
     }
    
     public ArrayList<Saint> intersec (ListaSaints recebido){
         ArrayList<Saint> saintsIguais = new ArrayList<>();
         ArrayList<Saint> arrayRecebido = recebido.todos();
         boolean iguais = false;
         for(int i = 0; i<this.saints.size();i++){
            for(int x=0; x<arrayRecebido.size();x++){
                if (saints.get(i).equals(arrayRecebido.get(x))) iguais = true;
            }
            if(iguais) saintsIguais.add(saints.get(i));
        }
         return saintsIguais;
     }
     
      public String getCSV() {
        String resultado = "";
        
        for(Saint saint : saints) {
            resultado += 
                saint.getSaint() + "," + 
                saint.getVida() + "," + 
                saint.getConstelacao().getNome() + "," + 
                saint.getArmadura().getCategoria() + "," +
                saint.getStatus() + "," + 
                saint.getGenero() + "," + 
                saint.getArmaduraVestida()  + "\n";
        }
        
        return resultado;
    }
}
