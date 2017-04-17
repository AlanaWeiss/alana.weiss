public class Armadura{
    private String constelacao;
    private Categoria categoria;    

    public Armadura(String constelacao, Categoria categoria){
        this.constelacao=constelacao;
        this.categoria = categoria;
    }
    
    public int getCategoria(){
     return this.categoria.getValor();
    }
    
    public Categoria getCat() {
        return this.categoria;
    }
    
    public String getConstelacao(){
        return this.constelacao;
    }
} 