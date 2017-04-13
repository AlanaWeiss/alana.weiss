public class Saint {
    private String nome;
    private Armadura armadura; 
    private boolean armaduraVestida;
    
    public Saint(String nome, Armadura armadura){
        this.nome = nome;
        this.armadura = armadura;
    }//construtor
    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }//metodo
    
}