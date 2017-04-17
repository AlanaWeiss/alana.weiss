public class Saint {
    private String nome;
    private Armadura armadura; 
    private boolean armaduraVestida;
    private Gênero genero = Gênero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    private int qtdSentidosDespertados = 5;
     
    //construtor
    public Saint(String nome, Armadura armadura){
        this.nome = nome;
        this.armadura = armadura;
        vida = 100;
    }
    
    public int getValorArmadura(){
        return this.armadura.getCategoria();
    }
    //metodo
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    
    //metodo retorno para usar no teste pq a variavel era privada
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }

    public Gênero getGenero(){
    return this.genero;
    }

    public void setGenero(Gênero genero){
    this.genero=genero;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public void perderVida(double dano){
       this.vida -= dano;
    }
   
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
}