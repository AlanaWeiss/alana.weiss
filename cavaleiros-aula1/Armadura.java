public class Armadura{
    private Constelacao constelacao;
    private Categoria categoria;    

    public Armadura(Constelacao constelacao, Categoria categoria){
        this.constelacao=constelacao;
        this.categoria = categoria;
    }
    
    public int getCategoria(){
     return this.categoria.getValor();
    }
    
    public Categoria getCat() {
        return this.categoria;
    }
    
    public Constelacao getConstelacao(){
        return this.constelacao;
    }
} 