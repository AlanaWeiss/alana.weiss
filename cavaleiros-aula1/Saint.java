public class Saint {
    private String nome;
    private Armadura armadura; 
    private boolean armaduraVestida;
	private Gênero genero = Gênero.NAO_INFORMADO;
    
    //construtor
    public Saint(String nome, Armadura armadura){
        this.nome = nome;
        this.armadura = armadura;
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
}