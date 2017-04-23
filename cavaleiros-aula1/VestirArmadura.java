public class VestirArmadura implements Movimento{
    Saint saint;
    
    public VestirArmadura (Saint saint){
        this.saint = saint;
    }
    
    public void executar(){
        this.saint.vestirArmadura();
    }
}
